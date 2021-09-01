package com.example.myapplication.model

import androidx.lifecycle.LiveData
import com.example.myapplication.MyApplication
import com.example.myapplication.network.CountryAPI
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {

    private val api: CountryAPI = Retrofit.Builder()
        .baseUrl("https://restcountries.eu/rest/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CountryAPI::class.java)

    fun getCountries(): LiveData<List<Country>> {
        return MyApplication.database!!.countryDao().countries
    }

    suspend fun fetchCountries(): Response<List<Country>> {
        return api.fetchAllCountries()
    }
}