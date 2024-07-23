package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseTestList
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
import javax.inject.Inject

class TestlerRepositoryImpl @Inject constructor() : TestRepository {
    override suspend fun getTestlerData(dersAdi: String, testNum: Int): List<TestlerEntity>? {
        var lessonList: List<TestlerEntity>? = null
        if (dersAdi == "Motor") {
            lessonList = DatabaseTestList.Motor
        }
        return lessonList
    }

}