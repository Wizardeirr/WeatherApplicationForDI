package com.volkankelleci.weatherapplicationfordi.repository

import com.volkankelleci.model.CryptoModel
import com.volkankelleci.model.WeatherAppModel
import com.volkankelleci.weatherapplicationfordi.Resource
import com.volkankelleci.weatherapplicationfordi.service.WeatherAPI


class WeatherDataDownloader(private val api:WeatherAPI):WeatherDataDownload {
    override suspend fun downloadWeatherDatas():Resource<List<CryptoModel>>{
        return try {
            val response = api.getData()
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