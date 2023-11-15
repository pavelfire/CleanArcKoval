package com.example.cleanarckoval220123.data.storage

import com.example.cleanarckoval220123.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}