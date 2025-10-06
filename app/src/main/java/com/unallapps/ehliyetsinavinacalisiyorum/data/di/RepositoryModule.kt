package com.unallapps.ehliyetsinavinacalisiyorum.data.di

import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.InformationCardRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.InformationCardRepositoryImpl
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.LessonRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.LessonRepositoryImpl
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestDetailRepository
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestsDetailRepositoryImpl
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
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository =
        userRepositoryImpl

    @Provides
    @Singleton
    fun provideTestsDetailRepository(testsDetailRepositoryImpl: TestsDetailRepositoryImpl): TestDetailRepository =
        testsDetailRepositoryImpl

    @Provides
    @Singleton
    fun provideSubjectsRepository(informationCardRepositoryImpl: InformationCardRepositoryImpl):
        InformationCardRepository =
        informationCardRepositoryImpl

    @Provides
    @Singleton
    fun provideLessonRepository(lessonRepositoryImpl: LessonRepositoryImpl): LessonRepository =
        lessonRepositoryImpl
}