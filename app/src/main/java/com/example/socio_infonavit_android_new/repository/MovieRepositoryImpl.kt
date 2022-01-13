package com.example.socio_infonavit_android_new.repository

import com.example.socio_infonavit_android_new.data.model.MovieList
import com.example.socio_infonavit_android_new.data.remote.MovieDataSource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieDataSource: MovieDataSource):MovieRepository {
    override suspend fun getMovies(): MovieList {
       return movieDataSource.getMovies()
    }

}