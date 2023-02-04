package com.example.cleanarckoval220123.domain.usecase

import com.example.cleanarckoval220123.domain.models.SaveUserNameParam
import com.example.cleanarckoval220123.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean{

        val oldUserName = userRepository.getName()

        if(oldUserName.firstName == param.name){
            return true
        }

        val result: Boolean = userRepository.saveName(saveparam = param)
        return result

    }
}