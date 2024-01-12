package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import com.unallapps.ehliyetsinavinacalisiyorum.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestlerEntity(val idTest: Int? = null,
    val content: String? = null,
    val imageTest: String? = null,
    val aTest: String? = null,
    val bTest: String? = null,
    val cTest: String? = null,
    val dTest: String? = null,
    val correct: String? = null,
    var color:Int?=R.color.white) : Parcelable
