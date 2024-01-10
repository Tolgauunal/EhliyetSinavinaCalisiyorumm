package com.unallapps.ehliyetsinavinacalisiyorum.data.state

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity

sealed class TestlerState {
    object Idle:TestlerState()
    object Loading:TestlerState()
    class result(val testlerList:List<TestlerEntity>):TestlerState()
}