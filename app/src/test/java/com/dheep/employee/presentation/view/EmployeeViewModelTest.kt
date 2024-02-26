package com.dheep.employee.presentation.view

import app.cash.turbine.test
import com.dheep.employee.core.common.DispatcherProvider
import com.dheep.employee.core.common.Resource
import com.dheep.employee.domain.model.Employee
import com.dheep.employee.domain.usecase.EmployeeUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class EmployeeViewModelTest {

    @Mock
    private lateinit var employeeUseCase: EmployeeUseCase

    private lateinit var dispatcherProvider: DispatcherProvider

    private lateinit var viewModel: EmployeeViewModel

    @Before
    fun setUp() {
        dispatcherProvider = TestDispatcherProvider()
        viewModel = EmployeeViewModel(employeeUseCase, dispatcherProvider)
    }

    @Test
    fun `Given employee list, then it waits for event success`() {
        runTest {

            //given
            val employees = listOf(
                Employee(
                    fullName = "Justine Mason",
                    phoneNumber = "5553280123",
                    emailAddress = "jmason.demo@squareup.com",
                    biography = "Engineer on the Point of Sale team.",
                    photoUrlSmall = "https://s3.amazonaws.com/sq-mobile-interview/photos/16c00560-6dd3-4af4-97a6-d4754e7f2394/small.jpg",
                    team = "Point of Sale"
                )
            )

            Mockito.doReturn(Resource.Success(employees)).`when`(employeeUseCase).getEmployeeData()

            //execute
            viewModel.getEmployeeData()

            //test
            viewModel.employeeState.test {
                assertEquals(EmployeeState.Success(employees), awaitItem())
            }
        }
    }

    @Test
    fun `Given empty employee list, then it waits for event success`() {
        runTest {

            //given
            Mockito.doReturn(Resource.Success(emptyList<Employee>())).`when`(employeeUseCase).getEmployeeData()

            //execute
            viewModel.getEmployeeData()

            //test
            viewModel.employeeState.test {
                assertEquals(EmployeeState.Empty, awaitItem())
            }
        }
    }

    @Test
    fun `Given empty employee list, then it waits for event failure`() {
        runTest {

            //given
            Mockito.doReturn(Resource.Error("error", data = null))
                .`when`(employeeUseCase).getEmployeeData()

            //execute
            viewModel.getEmployeeData()

            //test
            viewModel.employeeState.test {
                assertEquals(EmployeeState.Failure("error"), awaitItem())
            }
        }
    }
}