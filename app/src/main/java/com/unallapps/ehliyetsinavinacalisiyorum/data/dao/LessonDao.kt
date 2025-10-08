package com.unallapps.ehliyetsinavinacalisiyorum.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity

@Dao
interface LessonDao {
    @Insert
    suspend fun insertTest(testSaveIdEntity: TestSaveIdEntity)

    @Query("SELECT * FROM TestSaveIdEntity")
    suspend fun getAllTests(): List<TestSaveIdEntity>

    @Query("SELECT * FROM TestSaveIdEntity Where name=:testName")
    suspend fun getTestByName(testName: String): TestSaveIdEntity

    @Query(
        "UPDATE TestSaveIdEntity SET number = :testNumber, correctCount =:correctSize , " +
            "wrongCount =:wrongSize, questionCount =:questionSize WHERE name = :testName"
    )
    suspend fun updateTestProgress(
        testNumber: Int,
        correctSize: Int,
        wrongSize: Int,
        questionSize: Int,
        testName: String
    )
}