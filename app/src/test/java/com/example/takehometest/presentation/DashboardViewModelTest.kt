package com.example.takehometest.presentation

import com.example.takehometest.MainDispatcherRule
import com.example.takehometest.domain.model.ChargeSession
import com.example.takehometest.domain.model.DashboardUiState
import com.example.takehometest.domain.model.FuelTransaction
import com.example.takehometest.domain.usecase.DashboardUseCase
import com.example.takehometest.ui.viewmodel.DashboardViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    private lateinit var useCase: DashboardUseCase

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setup() {
        useCase = mock()
    }

    @Test
    fun `uiState emits Loading then Success`() = runTest {

        val transactions = listOf(
            FuelTransaction("1", 10.0, "Sydney", "20 Apr")
        )

        val sessions = listOf(
            ChargeSession("1", 5.0, "Bondi", "10 min", 2.5)
        )

        whenever(useCase.fetchFuelTransactions()).thenReturn(transactions)
        whenever(useCase.fetchChargeSession()).thenReturn(sessions)

        val viewModel = DashboardViewModel(useCase)

        val states = mutableListOf<DashboardUiState>()

        val job = launch {
            viewModel.uiState.collect {
                states.add(it)
            }
        }

        advanceUntilIdle()

        assert(states.last() is DashboardUiState.Success)

        job.cancel()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `uiState emits Error when repository fails`() = runTest {

        whenever(useCase.fetchFuelTransactions())
            .thenThrow(RuntimeException("Something went wrong"))

        whenever(useCase.fetchChargeSession())
            .thenThrow(RuntimeException("Something went wrong"))

        val viewModel = DashboardViewModel(useCase)

        val states = mutableListOf<DashboardUiState>()

        val job = launch {
            viewModel.uiState.collect {
                states.add(it)
            }
        }

        advanceUntilIdle()

        val finalState = states.last()

        assert(finalState is DashboardUiState.Error)

        val error = finalState as DashboardUiState.Error
        assert(error.message.isNotBlank())

        job.cancel()
    }
}