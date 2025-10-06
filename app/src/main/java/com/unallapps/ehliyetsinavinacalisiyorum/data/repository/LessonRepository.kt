package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity

interface LessonRepository {
    suspend fun insertLesson(testSaveIdEntity: TestSaveIdEntity)
    suspend fun updateLessonDetailInfo(
        testNumber: Int,
        lessonName: String,
        correctSum: Int,
        wrongSum: Int,
        questionNumber: Int
    )

    suspend fun getSavedInfoTestLesson(): List<TestSaveIdEntity>
    suspend fun getLessonData(lessonName: String): TestSaveIdEntity
}