package com.unallapps.ehliyetsinavinacalisiyorum.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.UserEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.repository.TestSaveIdRepository

@Dao
interface TestSaveIdDao {
    @Insert
    suspend fun insert(testSaveIdEntity: TestSaveIdEntity)

    @Query("SELECT * FROM TestSaveIdEntity")
    suspend fun getTestNumber(): List<TestSaveIdEntity>

    @Query("SELECT * FROM TestSaveIdEntity Where testName=:testName")
    suspend fun getTestData(testName: String): TestSaveIdEntity

    @Query("UPDATE TestSaveIdEntity SET testNumber = :testNum, correctSize =:dogruCevapSayisi , wrongSize =:yanlisCevapSayisi, questionSize=:soruSize WHERE testName = :testName")
    suspend fun updateTestSaveId(
        testNum: Int,
        dogruCevapSayisi: Int,
        yanlisCevapSayisi: Int,
        soruSize: Int,
        testName: String
    )
}