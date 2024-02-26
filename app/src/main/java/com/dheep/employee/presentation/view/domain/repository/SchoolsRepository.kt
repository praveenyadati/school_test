package com.dheep.employee.presentation.view.domain.repository

import com.dheep.employee.presentation.view.core.utils.Resource
import com.dheep.employee.presentation.view.data.datastore.entity.SchoolEntity

interface SchoolsRepository {

    suspend fun getSchoolsData(): Resource<List<SchoolEntity>>
}