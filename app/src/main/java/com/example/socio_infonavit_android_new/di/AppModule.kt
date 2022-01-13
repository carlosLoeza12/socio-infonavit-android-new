package com.example.socio_infonavit_android_new.di

import com.example.socio_infonavit_android_new.application.AppConstants
import com.example.socio_infonavit_android_new.repository.Service
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL_SOCIO)
        .client(AppConstants.okHttp.build())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit): Service = retrofit.create(Service::class.java)


}