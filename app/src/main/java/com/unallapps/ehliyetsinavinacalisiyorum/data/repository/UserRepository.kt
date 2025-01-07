package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity

interface UserRepository {
    suspend fun insert(userEntity: UserEntity)
    suspend fun getUser(): UserEntity?
    suspend fun getUserSize(): MutableList<UserEntity>
    suspend fun updateUserName(userName: String, userId: Int)
    suspend fun updateImage(image: ByteArray?, id: Int)
}