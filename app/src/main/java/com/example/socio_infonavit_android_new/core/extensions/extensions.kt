package com.example.socio_infonavit_android_new.core.extensions

import android.app.AlertDialog
import android.content.Context
import android.view.View
import com.example.socio_infonavit_android_new.databinding.DialogViewBinding
import com.example.socio_infonavit_android_new.R
import com.example.socio_infonavit_android_new.application.BaseApplication.Companion.prefs
import com.example.socio_infonavit_android_new.ui.benevits.BenevitsFragment


fun Context.loadDialog(message: String, action: Int){

    val viewDialog = View.inflate(this, R.layout.dialog_view, null)
    val dialog =  AlertDialog.Builder(this).setView(viewDialog).create()

    dialog.show()
    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    dialog.setCancelable(false)

    val binding: DialogViewBinding = DialogViewBinding.bind(viewDialog)
    binding.txtInformation.text = message

    binding.btnOk.setOnClickListener {
        when(action){
            1 ->{
                dialog.dismiss()
            }
            2 -> {
                dialog.dismiss()
                prefs.wipe()
            }
            else -> {
                dialog.dismiss()
            }
        }
    }

}
