package com.dheep.employee.presentation.view.core.di

import com.dheep.employee.presentation.view.core.utils.NetworkResources.BASE_URL
import com.dheep.employee.presentation.view.data.datastore.api.SchoolsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSchoolAPI(): SchoolsAPI {
        val client = OkHttpClient().newBuilder().build()
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SchoolsAPI::class.java)
    }
}