package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity
import com.unallapps.ehliyetsinavinacalisiyorum.data.state.TestlerListState

interface TestlerRepository {
    suspend fun getTest():TestlerListState
}