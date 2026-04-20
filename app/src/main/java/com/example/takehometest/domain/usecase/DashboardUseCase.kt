package com.example.takehometest.domain.usecase

import com.example.takehometest.domain.repository.DashboardRepository
import javax.inject.Inject

class DashboardUseCase @Inject constructor(private val dashboardRepository: DashboardRepository) {

    suspend fun fetchFuelTransactions() = dashboardRepository.fetchFuelTransactions()

    suspend fun fetchChargeSession() = dashboardRepository.fetchChargeSession()
}