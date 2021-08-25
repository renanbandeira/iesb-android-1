package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.model.SplashRepository
import com.example.myapplication.model.User

class SplashViewModel(private val splashRepository: SplashRepository) : ViewModel() {
    val authenticatedUserLiveData = MutableLiveData<User?>()

    fun checkIfUserIsAuthenticated() {
        splashRepository.checkIfUserIsAuthenticatedInFirebase(authenticatedUserLiveData)
    }

    class SplashViewModelFactory(private val splashRepository: SplashRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SplashViewModel(splashRepository) as T
        }

    }
}