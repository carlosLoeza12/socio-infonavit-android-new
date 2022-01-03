package com.example.socio_infonavit_android_new.data.model

import javax.inject.Inject

data class User @Inject constructor (val email: String, val password: String) {
}

data class member(val id: String, val name: String){

}
