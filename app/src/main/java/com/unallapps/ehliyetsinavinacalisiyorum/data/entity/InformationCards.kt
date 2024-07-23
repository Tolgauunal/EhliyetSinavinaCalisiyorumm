package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InformationCardsInfo(
    val id: Int, val description: String, val details: String? = null
) : Parcelable

@Parcelize
data class InformationCards(
    val id: Int?,
    val lessonName: String?,
    val lessonInformationCards: List<InformationCardsInfo>?
) : Parcelable