package com.example.socio_infonavit_android_new.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.socio_infonavit_android_new.R
import com.example.socio_infonavit_android_new.application.BaseApplication.Companion.prefs
import com.example.socio_infonavit_android_new.core.Result
import com.example.socio_infonavit_android_new.core.extensions.loadDialog
import com.example.socio_infonavit_android_new.data.model.DataUser
import com.example.socio_infonavit_android_new.data.model.User
import com.example.socio_infonavit_android_new.databinding.FragmentLoginBinding
import com.example.socio_infonavit_android_new.presentation.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var userEmail: String
    private lateinit var userPassword: String
    private val viewModel by activityViewModels<UserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //(requireActivity() as AppCompatActivity).supportActionBar?.hide()
        binding = FragmentLoginBinding.bind(view)

        binding.edtMail.addTextChangedListener(watcher)
        binding.edtPassword.addTextChangedListener(watcher)

        validateEdtPassword()

        binding.btnEnter.setOnClickListener {

            userEmail = binding.edtMail.text.toString().trim()
            userPassword = binding.edtPassword.text.toString().trim()
            savePreferences(userEmail)
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToBenevitsFragment())
            //makeLogin(User(DataUser(userEmail,userPassword)))
        }

    }

    private var watcher: TextWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            userEmail = binding.edtMail.text.toString().trim()
            userPassword = binding.edtPassword.text.toString().trim()

            binding.btnEnter.isEnabled = userEmail.isNotEmpty() && userPassword.isNotEmpty()

        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

    private fun validateEdtPassword(){

        binding.edtPassword.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {

                userEmail = binding.edtMail.text.toString().trim()
                userPassword = binding.edtPassword.text.toString().trim()

                if (userEmail.isEmpty() || userPassword.isEmpty()) {
                    Log.e("a", "vacios")
                } else {
                    makeLogin(User(DataUser(userEmail,userPassword)))
                }

            }
            return@setOnEditorActionListener true
        }

    }

    private fun makeLogin(User: User){
        viewModel.makeLogin(User).observe(viewLifecycleOwner, Observer {
            when(it){
                is Result.Loading ->{
                    binding.progressLogin.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressLogin.visibility = View.GONE
                    savePreferences(it.data.name)

                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToBenevitsFragment())
                    Log.e("data", it.data.id)

                }
                is Result.Failure -> {
                    binding.progressLogin.visibility = View.GONE

                    requireContext().loadDialog(getString(R.string.login_error),1)

                }
            }
        })

    }

    private fun savePreferences(nameUser: String){
        prefs.saveName(nameUser)
        prefs.saveSesion(true)
    }
}