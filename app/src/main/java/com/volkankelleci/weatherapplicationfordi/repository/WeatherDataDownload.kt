package com.volkankelleci.weatherapplicationfordi.repository

import com.volkankelleci.model.WeatherData
import com.volkankelleci.weatherapplicationfordi.Resource

interface WeatherDataDownload {
    suspend fun downloadWeatherDatas():Resource<List<WeatherData>>
}