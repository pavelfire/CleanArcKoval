package com.example.cleanarckoval220123.domain.usecase

import com.example.cleanarckoval220123.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean{
        return param.name.isNotEmpty()

    }
}