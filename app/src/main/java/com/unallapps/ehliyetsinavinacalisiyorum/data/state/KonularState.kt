package com.unallapps.ehliyetsinavinacalisiyorum.data.state

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.BilgiKartlariEntity

sealed class KonularState {
    object Idle:KonularState()
    object Loading:KonularState()
    class Result(val konu: List<BilgiKartlariEntity>):KonularState()
}