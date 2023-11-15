package com.example.cleanarckoval220123.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarckoval220123.data.repository.UserRepositoryImpl
import com.example.cleanarckoval220123.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarckoval220123.domain.usecase.GetUserNameUseCase
import com.example.cleanarckoval220123.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userStorage by lazy(LazyThreadSafetyMode.NONE) { SharedPrefUserStorage(context = context) }
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(userStorage = userStorage) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}