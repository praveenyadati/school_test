package com.dheep.employee.presentation.view.core.di

import com.dheep.employee.presentation.view.data.datastore.datasource.RemoteDataSource
import com.dheep.employee.presentation.view.data.repository.SchoolsRepositoryImpl
import com.dheep.employee.presentation.view.domain.repository.SchoolsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideSchoolRepository(dataSource: RemoteDataSource): SchoolsRepository {
        return SchoolsRepositoryImpl(dataSource)
    }
}