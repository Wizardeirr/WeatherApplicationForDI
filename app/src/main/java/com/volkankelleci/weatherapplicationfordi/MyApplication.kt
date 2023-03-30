package com.volkankelleci.weatherapplicationfordi

import android.app.Application
import org.koin.core.context.startKoin

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        fun start(){
            startKoin{
                modules()
            }
        }
    }
}