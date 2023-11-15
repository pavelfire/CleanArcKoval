package com.example.cleanarckoval220123.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarckoval220123.data.repository.UserRepositoryImpl
import com.example.cleanarckoval220123.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarckoval220123.domain.models.SaveUserNameParam
import com.example.cleanarckoval220123.domain.models.UserName
import com.example.cleanarckoval220123.domain.usecase.GetUserNameUseCase
import com.example.cleanarckoval220123.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String> = _resultLive

    init {
        Log.d("TAG", "MainViewModel created")
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameUseCase(param = params)
        _resultLive.value = "Save result = $result"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase()
        _resultLive.value = "${userName.firstName} ${userName.lastName}"
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "MainViewModel cleared")
    }
}