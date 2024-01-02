package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(@PrimaryKey(autoGenerate = true) val userid: Int = 0, val userName: String)
