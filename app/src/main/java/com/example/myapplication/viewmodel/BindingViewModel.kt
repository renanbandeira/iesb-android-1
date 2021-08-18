package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.model.Player
import com.example.myapplication.model.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BindingViewModel(private val repository: Repository): ViewModel() {
    val playersLiveData = MutableLiveData<List<Player>>()

    fun getPlayers() {
        playersLiveData.value = repository.getPlayers()
    }

    fun getPlayersUsingThread() {
        repository.getPlayersUsingThread { players ->
            playersLiveData.postValue(players)
        }
    }

    fun getPlayersUsingCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val players = withContext(Dispatchers.Default) {
                repository.getPlayersUsingCoroutines()
            }
            playersLiveData.value = players
        }
    }

    class BindingViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return BindingViewModel(repository) as T
        }

    }
}