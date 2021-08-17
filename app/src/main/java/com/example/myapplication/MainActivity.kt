package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.myapplication.listeners.OnClickSubmitListener
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    lateinit var rootView: View

    var pressedBackButtonTimes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)

        rootView = findViewById<ConstraintLayout>(R.id.root)
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Activity entrou no onResume", Toast.LENGTH_LONG).show()
        val button = findViewById<Button>(R.id.submit)
        button.setOnClickListener(OnClickSubmitListener(rootView))
    }

    override fun onBackPressed() {
        if (pressedBackButtonTimes == 0) {
            pressedBackButtonTimes++
            Toast.makeText(this, "Aperte novamente para sair da app", Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
        }

    }
}