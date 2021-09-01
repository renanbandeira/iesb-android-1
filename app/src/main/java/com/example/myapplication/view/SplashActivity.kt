package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.model.SplashRepository
import com.example.myapplication.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel = ViewModelProvider(this, SplashViewModel.SplashViewModelFactory(SplashRepository()))
            .get(SplashViewModel::class.java)

        viewModel.authenticatedUserLiveData.observe(this) { user ->
            if (user != null) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(MainActivity.USER_EXTRA, user)
                val sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                   putString("user", "Teste Shared Pref")
                   commit()
                }

                startActivity(intent)
//                finish()
            } else {
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.checkIfUserIsAuthenticated()
    }
}