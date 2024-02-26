package com.dheep.employee.presentation.view.data.datastore.datasource

import com.dheep.employee.presentation.view.data.datastore.api.SchoolsAPI
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: SchoolsAPI) {

    suspend fun getSchools() = api.getSchools()
}