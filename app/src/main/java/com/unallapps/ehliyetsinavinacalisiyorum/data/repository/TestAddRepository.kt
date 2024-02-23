package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import android.net.Uri
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity

interface TestAddRepository {
    suspend fun addTest(test: TestlerEntity)
}