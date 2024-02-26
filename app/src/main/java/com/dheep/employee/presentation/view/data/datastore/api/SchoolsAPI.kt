package com.dheep.employee.presentation.view.data.datastore.api

import com.dheep.employee.presentation.view.core.utils.NetworkResources.END_POINT
import com.dheep.employee.presentation.view.data.datastore.entity.SchoolEntity
import retrofit2.http.GET

interface SchoolsAPI {

    @GET(END_POINT)
    suspend fun getSchools() : List<SchoolEntity>
}