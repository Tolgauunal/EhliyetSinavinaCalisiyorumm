package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.InformationCards

interface InformationCardRepository {
    suspend fun getSubject(subjectName: String): InformationCards?
}