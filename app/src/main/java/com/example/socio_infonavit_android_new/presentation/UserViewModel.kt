package com.example.socio_infonavit_android_new.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.socio_infonavit_android_new.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import com.example.socio_infonavit_android_new.core.Result
import com.example.socio_infonavit_android_new.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository):ViewModel() {

    fun makeLogin(User: User) = liveData(Dispatchers.IO){
        emit(Result.Loading())
        try {
            emit(
                Result.Success(repository.makeLogin(User)
                )
            )
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

}