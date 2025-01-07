package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import android.os.Parcelable
import com.unallapps.ehliyetsinavinacalisiyorum.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestsEntity(val idTest: Int? = null,
                       val content: String? = null,
                       val imageTest: Int? = null,
                       val aTest: String? = null,
                       val bTest: String? = null,
                       val cTest: String? = null,
                       val dTest: String? = null,
                       val correct: String? = null,
                       var color:Int?=R.color.white) : Parcelable
