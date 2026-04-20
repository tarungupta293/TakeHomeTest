package com.example.takehometest.domain.model

sealed interface DashboardUiState {
    data object Loading : DashboardUiState
    data class Success(
        val transactions: List<FuelTransaction>,
        val sessions: List<ChargeSession>
    ) : DashboardUiState
    data class Error(val message: String) : DashboardUiState
}