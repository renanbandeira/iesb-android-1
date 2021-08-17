package com.example.myapplication.listeners

import android.view.View
import com.google.android.material.snackbar.Snackbar

class OnClickSubmitListener(val rootView: View) : View.OnClickListener {
    override fun onClick(v: View?) {
        Snackbar.make(rootView, "Botão clicado!", Snackbar.LENGTH_SHORT)
            .setAction("OK", View.OnClickListener {
                Snackbar.make(rootView, "OK clicado", Snackbar.LENGTH_SHORT).show()
            }).show()
    }
}