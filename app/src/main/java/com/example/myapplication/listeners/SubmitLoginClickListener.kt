package com.example.myapplication.listeners

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar

class SubmitLoginClickListener(val root: View, val context: Context): View.OnClickListener {
    override fun onClick(v: View?) {
        val snackbar = Snackbar.make(root, "Botão clicado", Snackbar.LENGTH_SHORT)
            .setAction("OK") {
                val snackbar1 =
                    Snackbar.make(root, "Ok clicado", Snackbar.LENGTH_SHORT)
                snackbar1.show()
            }
        snackbar.setTextColor(ContextCompat.getColor(context, R.color.purple_500))
        snackbar.show()
    }
}