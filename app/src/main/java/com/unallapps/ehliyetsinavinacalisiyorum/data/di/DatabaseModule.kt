package com.unallapps.ehliyetsinavinacalisiyorum.data.di

import android.content.Context
import androidx.room.Room
import com.unallapps.ehliyetsinavinacalisiyorum.data.AppDatabase
import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabaseModule(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context,AppDatabase::class.java,"database").build()
    }
    @Provides
    @Singleton
    fun provideUser(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}