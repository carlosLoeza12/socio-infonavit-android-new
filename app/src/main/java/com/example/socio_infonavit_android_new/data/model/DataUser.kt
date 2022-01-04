package com.example.socio_infonavit_android_new.data.model

data class User(
    val user: DataUser
)

data class DataUser(
    val email: String,
    val password: String
)

data class Member(
    val id: String,
    val name: String
)
