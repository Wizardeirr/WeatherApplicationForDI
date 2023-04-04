package com.volkankelleci.weatherapplicationfordi.repository

import com.volkankelleci.model.CryptoModel
import com.volkankelleci.model.WeatherAppModel
import com.volkankelleci.weatherapplicationfordi.Resource

interface WeatherDataDownload {
    suspend fun downloadWeatherDatas(): Resource<List<CryptoModel>>
}