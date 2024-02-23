package com.unallapps.ehliyetsinavinacalisiyorum.data.di

import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.BilgiKartlariRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.BilgiKartlariRepositoryImpl
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestAddRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestAddRepositoryImpl
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestSaveIdRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestSaveIdRepositoryImpl
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestlerRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestlerRepositoryImpl
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

    @Provides
    @Singleton
    fun provideTestlerRepository(testlerRepositoryImpl: TestlerRepositoryImpl): TestlerRepository =
        testlerRepositoryImpl

    @Provides
    @Singleton
    fun provideKonuAnlatimRepository(konuAnlatimRepositoyImpl: BilgiKartlariRepositoryImpl): BilgiKartlariRepository =
        konuAnlatimRepositoyImpl

    @Provides
    @Singleton
    fun provideTestSaveIdRepository(testSaveIdRepositoryImpl: TestSaveIdRepositoryImpl): TestSaveIdRepository =
        testSaveIdRepositoryImpl

    @Provides
    @Singleton
    fun provideTestAddRepository(testAddRepositoryImpl: TestAddRepositoryImpl): TestAddRepository =
        testAddRepositoryImpl
}