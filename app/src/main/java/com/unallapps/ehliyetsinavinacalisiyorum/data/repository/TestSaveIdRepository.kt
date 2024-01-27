package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity

interface TestSaveIdRepository {
    suspend fun insert(testSaveIdEntity: TestSaveIdEntity)
    suspend fun updateTestSave(testNum:Int,dersAdi:String,dogruCevapSayisi: Int, yanlisCevapSayisi: Int, soruSize: Int)
    suspend fun getTestList(): List<TestSaveIdEntity>
    suspend fun getTestData(dersAdi: String): TestSaveIdEntity

}