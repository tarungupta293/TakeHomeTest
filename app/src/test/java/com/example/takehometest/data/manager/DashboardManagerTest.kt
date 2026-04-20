package com.example.takehometest.data.manager

import com.example.takehometest.data.managers.DashboardManager
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class DashboardManagerTest {

    private lateinit var manager: DashboardManager

    @Before
    fun setup() {
        manager = DashboardManager()
    }

    @Test
    fun `fetchFuelTransactions returns data`() = runTest {

        val result = manager.fetchFuelTransactions()

        assert(result.isNotEmpty())
        assert(result.first().location.isNotBlank())
    }

    @Test
    fun `fetchChargeSessions returns data`() = runTest {

        val result = manager.fetchChargeSession()

        assert(result.isNotEmpty())
        assert(result.first().price >= 0)
    }
}