package com.example.myapplication.model

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth

class AuthRepository {

    fun firebaseSignInWithGoogle(googleAuthCredential: AuthCredential) : MutableLiveData<User> {
        val firebaseAuth = FirebaseAuth.getInstance()
        val authenticatedUserLiveData = MutableLiveData<User>()
        firebaseAuth.signInWithCredential(googleAuthCredential).addOnCompleteListener() { authTask ->
            if (authTask.isSuccessful) {
                val isNewUser = authTask.result.additionalUserInfo?.isNewUser
                val currentUser = firebaseAuth.currentUser
                currentUser?.let {
                    authenticatedUserLiveData.value = User(currentUser.uid, currentUser.displayName, currentUser.email, isNewUser?: false)
                }
            }
        }
        return authenticatedUserLiveData
    }
}