package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.TestDetailDao
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestsEntity
import javax.inject.Inject

class TestsDetailRepositoryImpl @Inject constructor(private val testDetailDao: TestDetailDao) :
    TestDetailRepository {
    override suspend fun getTestDetailList(
        lessonName: String
    ): List<TestsEntity>? {
        return testDetailDao.getLessonTestList(lessonName = lessonName)
    }

    override suspend fun insertTestList(testList: List<TestsEntity>) {
        testDetailDao.insertTestDetailList(testsEntity = testList)
    }

    override suspend fun updateFavoriteTest(testId: Int, favorite: Boolean) {
        testDetailDao.updateFavoriteTest(testId = testId, favorite = favorite)
    }

    override suspend fun getFavoriteTestList(): List<TestsEntity>? {
        return testDetailDao.getFavoriteTestList()
    }

    override suspend fun getAllTestListSize(): List<TestsEntity>?? {
        return testDetailDao.getAllTestListSize()
    }
}