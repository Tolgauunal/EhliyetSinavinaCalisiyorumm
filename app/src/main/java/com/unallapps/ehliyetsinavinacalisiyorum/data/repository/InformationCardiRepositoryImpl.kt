package com.unallapps.ehliyetsinavinacalisiyorum.data.repository

import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseInformationCard
import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.InformationCards
import javax.inject.Inject

class InformationCardiRepositoryImpl @Inject constructor() : InformationCardiRepository {
    override suspend fun getKonu(subjectName: String): InformationCards? {
        var informationCard: InformationCards? = null
        DatabaseInformationCard.informationCardData.forEach {
            if (it.lessonName == subjectName) {
                informationCard = it
            }
        }
        return informationCard
    }
}