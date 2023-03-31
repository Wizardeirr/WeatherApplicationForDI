package com.volkankelleci.weatherapplicationfordi.service

import com.volkankelleci.weatherapplicationfordi.data.WeatherData
import kotlinx.coroutines.flow.Flow
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    //URL: data/3.0/onecall?lat=33.44&lon=-94.04&exclude=hourly,daily&appid={d97957d008b633c512729f9554ae1c35}
    //API KEY : d97957d008b633c512729f9554ae1c35
    //BASE_URL : https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
    @GET("geo/1.0/direct?q=London&limit=5&appid=")
    suspend fun weatherSearch(
        @Query("q") cityName:String,
        @Query("appid") apiKey:String
    ): retrofit2.Response<List<WeatherData>>
}