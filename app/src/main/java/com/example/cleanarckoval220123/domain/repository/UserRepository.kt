package com.example.cleanarckoval220123.domain.repository

import com.example.cleanarckoval220123.domain.models.SaveUserNameParam
import com.example.cleanarckoval220123.domain.models.UserName

import kotlin.reflect.KProperty
interface UserRepository {

    fun saveName(saveparam: SaveUserNameParam): Boolean

    fun getName(): UserName

}