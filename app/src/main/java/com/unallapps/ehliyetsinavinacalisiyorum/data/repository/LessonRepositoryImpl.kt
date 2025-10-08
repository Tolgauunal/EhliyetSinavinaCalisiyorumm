package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.LessonDao
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import javax.inject.Inject

class LessonRepositoryImpl @Inject constructor(private val lessonDao: LessonDao) :
    LessonRepository {
    override suspend fun insertLesson(testSaveIdEntity: TestSaveIdEntity) {
        lessonDao.insertTest(testSaveIdEntity = testSaveIdEntity)
    }

    override suspend fun updateLessonDetailInfo(
        testNumber: Int,
        lessonName: String,
        correctSum: Int,
        wrongSum: Int,
        questionNumber: Int
    ) {
        lessonDao.updateTestProgress(
            testNumber = testNumber,
            testName = lessonName,
            correctSize = correctSum,
            wrongSize = wrongSum,
            questionSize = questionNumber
        )
    }

    override suspend fun getSavedInfoTestLesson(): List<TestSaveIdEntity> {
        return lessonDao.getAllTests()
    }

    override suspend fun getLessonData(lessonName: String): TestSaveIdEntity {
        return lessonDao.getTestByName(testName = lessonName)
    }

}