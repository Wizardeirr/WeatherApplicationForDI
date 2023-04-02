package com.volkankelleci.weatherapplicationfordi.DI

import com.volkankelleci.weatherapplicationfordi.repository.WeatherDataDownload
import com.volkankelleci.weatherapplicationfordi.repository.WeatherDataDownloader
import com.volkankelleci.weatherapplicationfordi.service.WeatherAPI
import com.volkankelleci.weatherapplicationfordi.util.Util.API_KEY
import com.volkankelleci.weatherapplicationfordi.util.Util.BASE_URL
import com.volkankelleci.weatherapplicationfordi.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.create
import retrofit2.create
import java.net.URI.create
import kotlin.math.sin


val weatherModule= module {
    single {
        Retrofit.Builder().
        baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).
        build().create(WeatherAPI::class.java)

    }
    single<WeatherDataDownload> {

        WeatherDataDownloader(get())
    }
    viewModel(){
        BaseViewModel(get())

    }
}