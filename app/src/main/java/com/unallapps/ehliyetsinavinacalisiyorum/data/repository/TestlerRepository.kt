package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity

interface TestlerRepository {
    suspend fun getTestlerData(dersAdi:String,testNum:Int):List<TestlerEntity>
}