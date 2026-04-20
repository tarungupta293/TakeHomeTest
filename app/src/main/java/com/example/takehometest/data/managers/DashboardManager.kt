package com.example.takehometest.data.managers

import com.example.takehometest.domain.model.ChargeSession
import com.example.takehometest.domain.model.FuelTransaction
import com.example.takehometest.domain.repository.DashboardRepository
import javax.inject.Inject

class DashboardManager @Inject constructor(): DashboardRepository {
    override suspend fun fetchFuelTransactions() =
        listOf(
            FuelTransaction("1", 80.5, "20 Apr", "Sydney"),
            FuelTransaction("2", 65.2, "18 Apr", "Parramatta"),
            FuelTransaction("3", 90.0, "15 Apr", "Chatswood")
        )

    override suspend fun fetchChargeSession() =
        listOf(
            ChargeSession("1", 25.0, "Sydney CBD", "30 mins", 12.5),
            ChargeSession("2", 18.0, "Bondi", "20 mins", 9.0)
        )
}