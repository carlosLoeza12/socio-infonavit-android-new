package com.example.socio_infonavit_android_new.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.socio_infonavit_android_new.core.Result
import com.example.socio_infonavit_android_new.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository):ViewModel(){

    fun getMovies() = liveData(Dispatchers.IO) {

        emit(Result.Loading())

        try {
            emit(
                Result.Success(movieRepository.getMovies())
            )
        }
        catch (e: Exception){
            emit(Result.Failure(e))
        }

    }

}