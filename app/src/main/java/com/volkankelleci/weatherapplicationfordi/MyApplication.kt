package com.volkankelleci.weatherapplicationfordi

import android.app.Application
import org.koin.core.context.startKoin

class MyApplication:Application() {

    fun start(){
        startKoin{
            modules()
        }
    }
}