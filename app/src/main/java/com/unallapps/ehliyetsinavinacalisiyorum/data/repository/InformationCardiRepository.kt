package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.InformationCards

interface InformationCardiRepository {
    suspend fun getKonu(konuAdi: String): InformationCards?
}