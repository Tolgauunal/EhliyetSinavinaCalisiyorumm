package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestSaveIdEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val correctCount: Int = 0,
    val wrongCount: Int = 0,
    val questionCount: Int = 0,
    val number: Int = 0
)