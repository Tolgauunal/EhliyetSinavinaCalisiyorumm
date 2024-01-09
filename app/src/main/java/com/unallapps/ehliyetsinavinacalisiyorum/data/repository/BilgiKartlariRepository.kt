package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.BilgiKartlariEntity

interface BilgiKartlariRepository {
    suspend fun getKonu(konuAdi:String):List<BilgiKartlariEntity>
}