package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.accessibility.AccessibilityEventCompat
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import com.example.myapplication.listeners.SubmitLoginClickListener


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        var root = findViewById<RelativeLayout>(R.id.root)
        Snackbar.make(root, "Activity criada", Snackbar.LENGTH_SHORT).show()
        findViewById<Button>(R.id.submit).setOnClickListener(SubmitLoginClickListener(root, this))
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Botão voltar clicado", Toast.LENGTH_SHORT).show()
        super.onBackPressed()
    }
}