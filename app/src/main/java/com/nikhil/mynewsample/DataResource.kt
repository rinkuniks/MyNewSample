package com.nikhil.mynewsample

class DataResource<T>(val status: DataStatus?, val statusCode: String?, val data: T?) {

    companion object {
        fun <T> success(statusCode: String?, data: T?): DataResource<T?> {
            return DataResource(DataStatus.SUCCESS, statusCode, data)
        }

        fun <T> loading(statusCode: String?, data: T?): DataResource<T> {
            return DataResource(DataStatus.LOADING, statusCode, data)
        }

        fun <T> error(statusCode: String?, data: T?): DataResource<T> {
            return DataResource(DataStatus.ERROR, statusCode, data)
        }
    }

}


enum class DataStatus {
    SUCCESS, LOADING, ERROR
}