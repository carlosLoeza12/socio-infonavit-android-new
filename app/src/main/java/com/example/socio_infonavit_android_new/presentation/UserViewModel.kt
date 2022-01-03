package com.example.socio_infonavit_android_new.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.socio_infonavit_android_new.data.model.User
import com.example.socio_infonavit_android_new.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import com.example.socio_infonavit_android_new.core.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository):ViewModel() {

    fun makeLogin(user: User) = liveData(Dispatchers.IO){
        emit(Result.Loading())
        try {
            emit(
                Result.Success(repository.makeLogin(user)
                )
            )
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

}