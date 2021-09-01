package com.example.myapplication.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.MainRepository
import com.example.myapplication.model.User
import com.example.myapplication.view.adapter.CountryAdapter
import com.example.myapplication.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    companion object {
        val USER_EXTRA = "user"
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE)
        val name = sharedPreferences.getString("user", "Outro")

        binding.user = User(uid = "1", name = name) // intent.getSerializableExtra(USER_EXTRA) as User

        viewModel = ViewModelProvider(this, MainViewModel.MainViewModelFactory(MainRepository()))
            .get(MainViewModel::class.java)

        binding.countryList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }

        viewModel.refreshCountries()

        viewModel.items.observe(this) { countries ->
            countries?.let {
                countryAdapter.update(it)
            }
        }

        viewModel.requestError.observe(this) { wrapper ->
            wrapper.getContentIfNotHandled()?.let { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}