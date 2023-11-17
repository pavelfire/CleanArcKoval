package com.example.cleanarckoval220123.di

import com.example.cleanarckoval220123.data.repository.UserRepositoryImpl
import com.example.cleanarckoval220123.data.storage.UserStorage
import com.example.cleanarckoval220123.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarckoval220123.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}