package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseTestList
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestsEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants
import javax.inject.Inject

class TestsRepositoryImpl @Inject constructor() : TestRepository {
    override suspend fun getTestsData(lessonName: String, testNumber: Int): List<TestsEntity>? {
        var lessonList: List<TestsEntity>? = null
        lessonList = when (lessonName) {
            Constants.STRING.ENGINE -> DatabaseTestList.Motor
            Constants.STRING.TRAFFIC -> DatabaseTestList.Trafik
            Constants.STRING.FIRST_AID -> DatabaseTestList.IlkYardim
            else -> emptyList()
        }
        return lessonList
    }

}