package com.unallapps.ehliyetsinavinacalisiyorum.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity

@Dao
interface LessonDao {
    @Insert
    suspend fun insert(testSaveIdEntity: TestSaveIdEntity)

    @Query("SELECT * FROM TestSaveIdEntity")
    suspend fun getTestNumber(): List<TestSaveIdEntity>

    @Query("SELECT * FROM TestSaveIdEntity Where testName=:testName")
    suspend fun getTestData(testName: String): TestSaveIdEntity

    @Query(
        "UPDATE TestSaveIdEntity SET testNumber = :testNumber, correctSize =:correctSize , " +
            "wrongSize =:wrongSize, questionSize =:questionSize WHERE testName = :testName"
    )
    suspend fun updateTestSaveId(
        testNumber: Int,
        correctSize: Int,
        wrongSize: Int,
        questionSize: Int,
        testName: String
    )
}