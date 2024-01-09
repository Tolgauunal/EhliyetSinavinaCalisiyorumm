package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BilgiKartlariEntity(var content: String? = null, var image: String? = null) : Parcelable