package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity

interface UserRepository {
    suspend fun insert(userEntity: UserEntity)
}