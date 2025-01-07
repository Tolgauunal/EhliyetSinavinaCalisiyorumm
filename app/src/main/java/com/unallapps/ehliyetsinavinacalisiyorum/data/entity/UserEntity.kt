package com.unallapps.ehliyetsinavinacalisiyorum.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val userid: Int = 0,
    val userName: String = Constants.String.DEFAULT_USER,
    var userPhoto: ByteArray? = null
)
