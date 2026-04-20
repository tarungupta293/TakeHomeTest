package com.example.takehometest.data.DI

import com.example.takehometest.data.managers.DashboardManager
import com.example.takehometest.domain.repository.DashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDashboardRepository(
        impl: DashboardManager
    ): DashboardRepository
}