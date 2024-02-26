package com.dheep.employee.presentation.view.data.repository

import com.dheep.employee.presentation.view.core.utils.Resource
import com.dheep.employee.presentation.view.data.datastore.datasource.RemoteDataSource
import com.dheep.employee.presentation.view.data.datastore.entity.SchoolEntity
import com.dheep.employee.presentation.view.domain.repository.SchoolsRepository
import javax.inject.Inject

class SchoolsRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    SchoolsRepository {

    override suspend fun getSchoolsData(): Resource<List<SchoolEntity>> {
        return try {
            val data = remoteDataSource.getSchools()
            Resource.Success(data)
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }

}