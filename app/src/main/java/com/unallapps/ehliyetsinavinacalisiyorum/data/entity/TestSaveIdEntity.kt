package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestSaveIdEntity(@PrimaryKey(autoGenerate = true) val testId: Int = 0,
    val testName:String,
    val dogruSayisi:Int=0,
    val yanlisSayisi:Int=0,
    val soruSize:Int=0,
    val testNum: Int=0)