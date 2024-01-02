package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
data class UserEntity(@PrimaryKey(autoGenerate = true) val userid: Int = 0, val userName: String)
