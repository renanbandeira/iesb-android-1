package com.example.myapplication.network

import com.example.myapplication.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryAPI {

    @GET("all")
    suspend fun fetchAllCountries(): Response<List<Country>>
}