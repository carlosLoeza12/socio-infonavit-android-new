package com.example.socio_infonavit_android_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socio_infonavit_android_new.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}