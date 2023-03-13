package com.nikhil.mynewsample

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

abstract class NetworkResource<T : NikhilGenericApiResponse> {

    fun fetchFromApi() {
        var response = createCall()
    }

    @WorkerThread
    abstract fun processResponse(data: T): DataResource<T>

    @MainThread
    abstract fun createCall(): LiveData<T?>

    init {
        fetchFromApi()
    }

}

class infor {

}


