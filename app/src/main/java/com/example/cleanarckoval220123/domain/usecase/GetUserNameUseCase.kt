package com.example.cleanarckoval220123.domain.usecase

import com.example.cleanarckoval220123.domain.models.UserName
import com.example.cleanarckoval220123.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    operator fun invoke (): UserName{
        return userRepository.getName()
    }
}