package com.example.cleanarckoval220123.domain.usecase

import com.example.cleanarckoval220123.domain.models.UserName
import com.example.cleanarckoval220123.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getName()
    }
}