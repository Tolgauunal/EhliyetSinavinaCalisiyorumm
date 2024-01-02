package com.unallapps.ehliyetsinavinacalisiyorum.data.di

import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository = userRepositoryImpl
}