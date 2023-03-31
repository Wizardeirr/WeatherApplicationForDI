package com.volkankelleci.weatherapplicationfordi.repository

import com.volkankelleci.weatherapplicationfordi.Resource
import com.volkankelleci.weatherapplicationfordi.util.Util.API_KEY
import com.volkankelleci.weatherapplicationfordi.data.WeatherData
import com.volkankelleci.weatherapplicationfordi.service.WeatherAPI

class WeatherDataDownloader(private val api:WeatherAPI):WeatherDataDownload {
    override suspend fun downloadWeatherDatas(): Resource<List<WeatherData>> {
        return try {
            val response = api.weatherSearch("London",API_KEY)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)
            } else {
                Resource.error("Error",null)
            }
        } catch (e: Exception) {
            Resource.error("No data!",null)
        }
    }
}