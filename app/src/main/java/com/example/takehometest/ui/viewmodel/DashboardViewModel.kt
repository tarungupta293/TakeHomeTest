package com.example.takehometest.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takehometest.domain.model.DashboardUiState
import com.example.takehometest.domain.usecase.DashboardUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class DashboardViewModel @Inject constructor(private val dashboardUseCase: DashboardUseCase): ViewModel() {

    private val _uiState = MutableStateFlow<DashboardUiState>(
        DashboardUiState.Loading
    )
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    init {
        loadDashboard()
    }

    private fun loadDashboard() {
        viewModelScope.launch {
            _uiState.value = DashboardUiState.Loading

            try {
                val transactions = dashboardUseCase.fetchFuelTransactions()
                val sessions = dashboardUseCase.fetchChargeSession()

                _uiState.value = DashboardUiState.Success(
                    transactions = transactions.take(2),
                    sessions = sessions.take(2)
                )

            } catch (e: Exception) {
                _uiState.value = DashboardUiState.Error(
                    message = e.message ?: "Something went wrong"
                )
            }
        }
    }
}