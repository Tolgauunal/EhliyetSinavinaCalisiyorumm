package com.unallapps.ehliyetsinavinacalisiyorum.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insert(userEntity: UserEntity)
}