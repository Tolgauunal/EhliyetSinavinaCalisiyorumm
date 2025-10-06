package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestsEntity(
    val lessonName: String? = null,
    @PrimaryKey(autoGenerate = true) val testId: Int = 0,
    val idTest: Int? = null,
    val content: String? = null,
    val imageTest: Int? = null,
    val aTest: String? = null,
    val bTest: String? = null,
    val cTest: String? = null,
    val dTest: String? = null,
    val correct: String? = null,
    val favorite: Boolean = false
)
