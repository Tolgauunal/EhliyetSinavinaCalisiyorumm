package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.UserDao
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {
    override suspend fun insert(userEntity: UserEntity) {
        return userDao.insert(userEntity)
    }
}