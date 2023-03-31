package com.volkankelleci.weatherapplicationfordi.repository

import com.volkankelleci.weatherapplicationfordi.Resource
import com.volkankelleci.weatherapplicationfordi.data.WeatherData

interface WeatherDataDownload {
    suspend fun downloadWeatherDatas():Resource<List<WeatherData>>
}