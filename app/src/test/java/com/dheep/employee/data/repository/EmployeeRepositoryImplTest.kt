package com.dheep.employee.data.repository

import com.dheep.employee.data.datasorce.EmployeeRemoteDataSource
import com.dheep.employee.data.datasorce.api.EmployeeApi
import com.dheep.employee.data.mapper.EmployeeDtoMapper
import com.dheep.employee.domain.repository.EmployeeRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class EmployeeRepositoryImplTest {

    private lateinit var api: EmployeeApi

    private lateinit var dtoMapper: EmployeeDtoMapper

    private lateinit var dataSource: EmployeeRemoteDataSource

    private lateinit var repository: EmployeeRepository

    @Before
    fun setUp() {
        api = mockk()
        dataSource = EmployeeRemoteDataSource(api)
        dtoMapper = EmployeeDtoMapper()
        repository = EmployeeRepositoryImpl(dataSource, dtoMapper)
    }

    @Test
    fun `Given employee list, then it waits for event success`() {
        runTest {

            repository.getEmployeeData()

            coVerify { api.getEmployeeData() }
        }
    }

}