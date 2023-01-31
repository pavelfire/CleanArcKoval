package com.example.cleanarckoval220123.domain.usecase

import com.example.cleanarckoval220123.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName{
        return UserName("Jonny", "Oueahh")

    }
}