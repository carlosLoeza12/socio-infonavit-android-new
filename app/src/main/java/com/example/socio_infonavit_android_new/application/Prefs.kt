package com.example.socio_infonavit_android_new.application

import android.content.Context

class Prefs(val context: Context) {

    val SHARED_NAME = "mydbt"
    val SHARED_USER_NAME = ""
    val SHARED_USER_SESION = ""
    val storage = context.getSharedPreferences(SHARED_NAME,0)

    fun saveName(name: String){
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun saveSesion(sesion: Boolean){
        storage.edit().putBoolean(SHARED_USER_SESION, sesion).apply()
    }

    fun getName(): String? {
        return storage.getString(SHARED_USER_NAME, "")
    }

    fun getSesion(): Boolean{
        return  storage.getBoolean(SHARED_USER_SESION, false)
    }



}