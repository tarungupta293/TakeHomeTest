package com.example.takehometest.domain.model

data class ChargeSession(
    val id: String,
    val price: Double,
    val location: String,
    val duration: String,
    val energy: Double
)
