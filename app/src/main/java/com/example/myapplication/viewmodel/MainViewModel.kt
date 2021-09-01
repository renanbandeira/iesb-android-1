package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MyApplication
import com.example.myapplication.model.EventWrapper
import com.example.myapplication.model.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    val items = repository.getCountries()
    val requestError = MutableLiveData<EventWrapper<String>>()

    fun refreshCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.fetchCountries()

                if (response.isSuccessful) {
                    MyApplication.database!!.countryDao().insertAllCountries(response.body()!!)
                } else {
                    withContext(Dispatchers.Main) {
                        requestError.value = EventWrapper("Erro ao atualizar os dados")
                    }
                }
            } catch (error: Exception) {
                withContext(Dispatchers.Main) {
                    requestError.value = EventWrapper("Erro ao atualizar os dados")
                }
            }
        }
    }

    class MainViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }
}