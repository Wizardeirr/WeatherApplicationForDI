package com.volkankelleci.weatherapplicationfordi.data


import com.google.gson.annotations.SerializedName

data class WeatherData(
    val `data`: List<Data>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int,

)