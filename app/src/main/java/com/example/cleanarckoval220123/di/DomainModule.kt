package com.example.cleanarckoval220123.di

import com.example.cleanarckoval220123.domain.usecase.GetUserNameUseCase
import com.example.cleanarckoval220123.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory {
        SaveUserNameUseCase(userRepository = get())
    }
}