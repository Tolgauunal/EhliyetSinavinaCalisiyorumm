package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestSaveIdEntity(
    @PrimaryKey(autoGenerate = true) val testId: Int = 0,
    val testName: String,
    val correctSize: Int = 0,
    val wrongSize: Int = 0,
    val questionSize: Int = 0,
    val testNumber: Int = 0
)