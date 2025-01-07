package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestsEntity

interface TestRepository {
    suspend fun getTestsData(lessonName: String, testNumber: Int): List<TestsEntity>?
}