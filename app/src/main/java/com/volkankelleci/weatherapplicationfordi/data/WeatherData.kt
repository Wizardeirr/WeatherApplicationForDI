package com.volkankelleci.model


data class WeatherData(
    val current: Current,
    val location: Location,
    val request: Request
)