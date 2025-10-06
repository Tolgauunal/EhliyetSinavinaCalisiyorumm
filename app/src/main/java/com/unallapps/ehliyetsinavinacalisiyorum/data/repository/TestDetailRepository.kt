package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestsEntity

interface TestDetailRepository {
    suspend fun getTestDetailList(lessonName: String): List<TestsEntity>?
    suspend fun insertTestList(testList: List<TestsEntity>)
    suspend fun updateFavoriteTest(testId: Int, favorite: Boolean)
    suspend fun getFavoriteTestList(): List<TestsEntity>?
}