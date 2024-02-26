package com.dheep.employee.presentation.view.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dheep.employee.presentation.view.core.utils.Resource
import com.dheep.employee.presentation.view.domain.repository.SchoolsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolsViewModel @Inject constructor(
    private val repository: SchoolsRepository
) : ViewModel() {

    private val _schoolDataState = MutableStateFlow<UIState>(UIState.Loading)
    val schoolDataState = _schoolDataState.asStateFlow()

    init {
        getSchoolsData()
    }

    private fun getSchoolsData() {
        _schoolDataState.value = UIState.Loading
        viewModelScope.launch {
            when (val result = repository.getSchoolsData()) {
                is Resource.Success -> {
                    val data = result.data
                    data?.let {
                        if (it.isNotEmpty()) {
                            _schoolDataState.value = UIState.Success(it)
                        } else {
                            _schoolDataState.value = UIState.Empty
                        }
                    }
                }

                is Resource.Error -> {
                    _schoolDataState.value = UIState.Error(result.error)
                }
            }
        }
    }
}