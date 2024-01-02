package com.unallapps.ehliyetsinavinacalisiyorum.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insert(userEntity: UserEntity)

    @Query("SELECT * FROM USERENTITY")
    suspend fun getUserSize(): MutableList<UserEntity>

    @Query("SELECT * FROM USERENTITY")
    suspend fun getUserName(): UserEntity

    @Query("UPDATE UserEntity SET userName = :userName WHERE userid = :id")
    suspend fun updateUserImage(userName: String, id: Int)
}