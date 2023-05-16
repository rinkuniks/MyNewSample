package com.nikhil.mynewsample

class DataResource<T>(val status: DataStatus?, val statusCode: Int?, val data: T?) {

    companion object {
        fun <T> success(statusCode: Int?, data: T?): DataResource<T?> {
            return DataResource(DataStatus.SUCCESS, statusCode, data)
        }

        fun <T> loading(statusCode: Int?, data: T?): DataResource<T> {
            return DataResource(DataStatus.LOADING, statusCode, data)
        }

        fun <T> error(statusCode: Int?, data: T?): DataResource<T> {
            return DataResource(DataStatus.ERROR, statusCode, data)
        }
    }

}


enum class DataStatus {
    SUCCESS, LOADING, ERROR
}