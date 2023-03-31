package com.volkankelleci.weatherapplicationfordi

import android.app.Application
import com.volkankelleci.weatherapplicationfordi.DI.weatherModule
import org.koin.core.context.startKoin
import org.koin.core.time.Timer.Companion.start

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
            startKoin{
                modules(weatherModule)
            }
        }
    }
