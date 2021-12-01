package com.example.musicgalery.mvvm

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MvvmViewModel: ViewModel() {
    val isLoginSuccessLiveData = MutableLiveData<Unit>()
    val isLoginFailedLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()
    val titleLiveData = MutableLiveData<String>()

    private val authModel = MvvmModel()

    fun onLoginClicked(email: String, password: String) {
        showProgressLiveData.postValue(Unit)
        Handler(Looper.getMainLooper()).postDelayed({
            val isSuccess = authModel.onLoginClicked(email, password)
            hideProgressLiveData.postValue(Unit)
            if (isSuccess) {
                isLoginSuccessLiveData.postValue(Unit)
            } else {
                isLoginFailedLiveData.postValue(Unit)
            }
        }, 5000)
    }
}