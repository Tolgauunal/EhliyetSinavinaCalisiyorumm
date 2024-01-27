package com.unallapps.ehliyetsinavinacalisiyorum.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.TestSaveIdDao
import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.UserDao
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity

@Database(entities = [UserEntity::class,TestSaveIdEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun testSaveIdDao(): TestSaveIdDao
}