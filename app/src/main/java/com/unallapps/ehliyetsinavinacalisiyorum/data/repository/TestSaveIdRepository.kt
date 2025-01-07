package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity

interface TestSaveIdRepository {
    suspend fun insert(testSaveIdEntity: TestSaveIdEntity)
    suspend fun updateTestSave(
        testNumber: Int,
        lessonName: String,
        correctSum: Int,
        wrongSum: Int,
        questionNumber: Int
    )

    suspend fun getTestList(): List<TestSaveIdEntity>
    suspend fun getTestData(lessonName: String): TestSaveIdEntity
}