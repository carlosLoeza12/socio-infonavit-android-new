package com.example.socio_infonavit_android_new.application

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object AppConstants {
    //API
    const val BASE_URL = "https://staging.api.socioinfonavit.io/api/v1/"

    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var okHttp = OkHttpClient.Builder().addInterceptor(logger)


}