package com.example.socio_infonavit_android_new.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.socio_infonavit_android_new.R
import com.example.socio_infonavit_android_new.application.BaseApplication.Companion.prefs
import com.example.socio_infonavit_android_new.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        binding.imgLogo.startAnimation(animation)

        timer()
    }

    private fun timer() {
        binding.progress.visibility = View.VISIBLE

        val timer = object : CountDownTimer(1500, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                validateSesion()
            }
        }
        timer.start()

    }

    private fun validateSesion(){
       if(prefs.getSesion()){
           findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToBenevitsFragment())
       }else{
           findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
       }
    }
}