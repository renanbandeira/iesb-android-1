package com.example.myapplication.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Player
import com.example.myapplication.model.Repository
import com.example.myapplication.viewmodel.BindingViewModel

class BindingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: BindingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, BindingViewModel.BindingViewModelFactory(Repository()))
            .get(BindingViewModel::class.java)

        viewModel.playersLiveData.observe(this) { players ->
            binding.player = players[0]
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getPlayersUsingCoroutines()
    }
}