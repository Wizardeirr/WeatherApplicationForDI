package com.volkankelleci.weatherapplicationfordi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volkankelleci.model.CryptoModel
import com.volkankelleci.weatherapplicationfordi.Resource
import com.volkankelleci.weatherapplicationfordi.repository.WeatherDataDownload
import kotlinx.coroutines.*

class BaseViewModel(
    private val weatherDataDownload: WeatherDataDownload
):ViewModel() {
    val cryptoList = MutableLiveData<Resource<List<CryptoModel>>>()
    val cryptoError = MutableLiveData<Resource<Boolean>>()
    val cryptoLoading = MutableLiveData<Resource<Boolean>>()
    private var job : Job? = null

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
        cryptoError.value = Resource.error(throwable.localizedMessage ?: "error!",data = true)
    }
    fun getDataFromAPI() {
        cryptoLoading.value = Resource.loading(true)
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val resource = weatherDataDownload.downloadWeatherDatas()
            withContext(Dispatchers.Main) {
                resource.data?.let {
                    cryptoLoading.value = Resource.loading(false)
                    cryptoError.value = Resource.error("",data = false)
                    cryptoList.value = resource
                }
            }

        }

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}