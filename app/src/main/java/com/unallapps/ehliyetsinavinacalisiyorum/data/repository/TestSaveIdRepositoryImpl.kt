package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.dao.TestSaveIdDao
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestSaveIdEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
import javax.inject.Inject

class TestSaveIdRepositoryImpl @Inject constructor(private val testSaveIdDao: TestSaveIdDao) : TestSaveIdRepository {
    override suspend fun insert(testSaveIdEntity: TestSaveIdEntity) {
        testSaveIdDao.insert(testSaveIdEntity = testSaveIdEntity)
    }

    override suspend fun updateTestSave(testNum: Int,
        dersAdi: String,
        dogruCevapSayisi: Int,
        yanlisCevapSayisi: Int,
        soruSize: Int) {
        testSaveIdDao.updateTestSaveId(testNum = testNum,
            testName = dersAdi,
            dogruCevapSayisi = dogruCevapSayisi,
            yanlisCevapSayisi = yanlisCevapSayisi,
            soruSize = soruSize)
    }

    override suspend fun getTestList(): List<TestSaveIdEntity> {
        return testSaveIdDao.getTestNumber()
    }

    override suspend fun getTestData(dersAdi: String): TestSaveIdEntity {
        return testSaveIdDao.getTestData(testName = dersAdi)
    }

}