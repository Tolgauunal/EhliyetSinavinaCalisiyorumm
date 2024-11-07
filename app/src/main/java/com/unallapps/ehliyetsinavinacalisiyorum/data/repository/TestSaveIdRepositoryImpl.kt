package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.TestSaveIdDao
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import javax.inject.Inject

class TestSaveIdRepositoryImpl @Inject constructor(private val testSaveIdDao: TestSaveIdDao) : TestSaveIdRepository {
    override suspend fun insert(testSaveIdEntity: TestSaveIdEntity) {
        testSaveIdDao.insert(testSaveIdEntity = testSaveIdEntity)
    }

    override suspend fun updateTestSave(testNumber: Int,
                                        lessonName: String,
                                        correctSum: Int,
                                        wrongSum: Int,
                                        questionNumber: Int) {
        testSaveIdDao.updateTestSaveId(testNum = testNumber,
            testName = lessonName,
            dogruCevapSayisi = correctSum,
            yanlisCevapSayisi = wrongSum,
            soruSize = questionNumber)
    }

    override suspend fun getTestList(): List<TestSaveIdEntity> {
        return testSaveIdDao.getTestNumber()
    }

    override suspend fun getTestData(dersAdi: String): TestSaveIdEntity {
        return testSaveIdDao.getTestData(testName = dersAdi)
    }

}