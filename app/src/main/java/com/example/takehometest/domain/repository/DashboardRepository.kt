package com.example.takehometest.domain.repository

import com.example.takehometest.domain.model.ChargeSession
import com.example.takehometest.domain.model.FuelTransaction

interface DashboardRepository {

    suspend fun fetchFuelTransactions(): List<FuelTransaction>

    suspend fun fetchChargeSession(): List<ChargeSession>
}