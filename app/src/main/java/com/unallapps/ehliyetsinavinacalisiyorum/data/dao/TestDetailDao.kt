package com.unallapps.ehliyetsinavinacalisiyorum.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestsEntity

@Dao
interface TestDetailDao {
    @Insert
    suspend fun insertTestDetailList(testsEntity: List<TestsEntity>)

    @Query("SELECT * FROM TestsEntity Where lessonName=:lessonName")
    suspend fun getLessonTestList(lessonName: String): List<TestsEntity>

    @Query(
        "UPDATE TestsEntity SET favorite = :favorite WHERE testId = :testId"
    )
    suspend fun updateFavoriteTest(
        testId: Int,
        favorite: Boolean
    )
    @Query("SELECT * FROM TestsEntity WHERE favorite = 1")
    suspend fun getFavoriteTestList(): List<TestsEntity>

    @Query("SELECT * FROM TestsEntity")
    suspend fun getAllTestListSize(): List<TestsEntity>
}