package com.example.cleanarckoval220123.data.repository

import com.example.cleanarckoval220123.data.storage.models.User
import com.example.cleanarckoval220123.data.storage.UserStorage
import com.example.cleanarckoval220123.domain.models.SaveUserNameParam
import com.example.cleanarckoval220123.domain.models.UserName
import com.example.cleanarckoval220123.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository{

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        return mapToDomain(userStorage.get())
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = "in repo save")
    }
}