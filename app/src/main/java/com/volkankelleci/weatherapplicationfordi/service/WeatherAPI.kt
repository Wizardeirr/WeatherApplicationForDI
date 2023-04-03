package com.volkankelleci.weatherapplicationfordi.service

import com.volkankelleci.model.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    //URL: data/3.0/onecall?lat=33.44&lon=-94.04&exclude=hourly,daily&appid={d97957d008b633c512729f9554ae1c35}
    //API KEY : d97957d008b633c512729f9554ae1c35
    //BASE_URL : https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
    @GET("current?access_key=222ceeb7d76043091460580c254eb5c2&")
    fun getData(@Query("query") cityName:String):Response<List<WeatherData>>
}