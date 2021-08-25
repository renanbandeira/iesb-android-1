package com.example.myapplication.model

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth

class SplashRepository {
    fun checkIfUserIsAuthenticatedInFirebase(isUserAuthenticatedLiveData: MutableLiveData<User?>) {
        val firebaseAuth = FirebaseAuth.getInstance()
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            isUserAuthenticatedLiveData.value = null
        } else {
            isUserAuthenticatedLiveData.value = User(firebaseUser.uid, firebaseUser.displayName, firebaseUser.email)
        }
    }
}