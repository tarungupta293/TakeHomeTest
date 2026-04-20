package com.example.takehometest.data.DI

import com.example.takehometest.data.managers.DashboardManager
import com.example.takehometest.domain.repository.DashboardRepository
import com.example.takehometest.domain.usecase.DashboardUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TakeHomeModule {

    @Provides
    @Singleton
    fun provideDashboardUseCase(dashboardRepository: DashboardRepository): DashboardUseCase {
        return DashboardUseCase(dashboardRepository)
    }
}