package com.nikhil.mynewsample

import android.database.Observable
import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

abstract class NetworkResource<S : NikhilGenericApiResponse> {

    var result = MediatorLiveData<DataResource<S?>>()
    var dataInfo = MediatorLiveData<S?>()
    private  val TAG = "LoginActivity"

    suspend fun fetchFromApi() {
        val response = createCall()
        dataInfo.postValue(response)
        Log.d(TAG, "enableLoginDetails: 20")
        dataInfo.observeForever(object : Observer<S?> {
            override fun onChanged(t: S?) {
                Log.d(TAG, "enableLoginDetails: 19")
                if (checkForApiError(t)) {
                    Log.d(TAG, "enableLoginDetails: 5")
                    result.postValue(processResponse(t))
                }
                dataInfo.removeObserver(this)
            }
        })
    }

    abstract fun processResponse(data: S?): DataResource<S?>

    abstract suspend fun createCall(): S?

    abstract var isLoading: Boolean

    fun toLiveData(): LiveData<DataResource<S?>> = result

    private fun checkForApiError(response: S?): Boolean {
        response?.let { it ->
            if (response.code == 100) {
                result.postValue(DataResource.error(response.code, it))
            return false
            } else {
                Log.d(TAG, "enableLoginDetails: 6")
                return true
            }
        } ?: kotlin.run {
            Log.d(TAG, "enableLoginDetails: 7")
            result.postValue(DataResource.error(11, null))
            return false
        }
    }

    init {
        CoroutineScope(Dispatchers.Main).launch {
            fetchFromApi()
        }
    }

}



