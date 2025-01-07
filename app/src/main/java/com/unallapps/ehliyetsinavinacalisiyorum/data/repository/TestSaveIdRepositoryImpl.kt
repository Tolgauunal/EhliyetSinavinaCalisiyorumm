package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.TestSaveIdDao
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import javax.inject.Inject

class TestSaveIdRepositoryImpl @Inject constructor(private val testSaveIdDao: TestSaveIdDao) :
    TestSaveIdRepository {
    override suspend fun insert(testSaveIdEntity: TestSaveIdEntity) {
        testSaveIdDao.insert(testSaveIdEntity = testSaveIdEntity)
    }

    override suspend fun updateTestSave(
        testNumber: Int,
        lessonName: String,
        correctSum: Int,
        wrongSum: Int,
        questionNumber: Int
    ) {
        testSaveIdDao.updateTestSaveId(
            testNumber = testNumber,
            testName = lessonName,
            correctSize = correctSum,
            wrongSize = wrongSum,
            questionSize = questionNumber
        )
    }

    override suspend fun getTestList(): List<TestSaveIdEntity> {
        return testSaveIdDao.getTestNumber()
    }

    override suspend fun getTestData(lessonName: String): TestSaveIdEntity {
        return testSaveIdDao.getTestData(testName = lessonName)
    }

}