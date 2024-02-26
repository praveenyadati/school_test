package com.dheep.employee.presentation.view.presentation.view

import com.dheep.employee.presentation.view.data.datastore.entity.SchoolEntity

sealed interface UIState {

    data class Success(val data: List<SchoolEntity>): UIState

    object Loading: UIState

    object Empty: UIState

    data class Error(val message: String?): UIState
}