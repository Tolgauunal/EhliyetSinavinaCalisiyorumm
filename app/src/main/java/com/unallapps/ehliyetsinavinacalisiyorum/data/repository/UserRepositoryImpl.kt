package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.UserDao
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {
    override suspend fun insert(userEntity: UserEntity) {
        return userDao.insertUser(userEntity)
    }

    override suspend fun getUser(): UserEntity {
        return userDao.getUser()
    }

    override suspend fun getUserSize(): MutableList<UserEntity> {
        return userDao.getAllUsers()
    }

    override suspend fun updateUserName(userName: String, userId: Int) {
        return userDao.updateUserName(userName, userId)
    }
    override suspend fun updateImage(image: ByteArray?, id: Int) {
        return userDao.updateUserPhoto(image = image, id)
    }
}