package com.unallapps.ehliyetsinavinacalisiyorum.data.state

import com.unallapps.ehliyetsinavinacalisiyorum.data.entity.TestlerEntity

sealed class TestlerListState{
    object Idle:TestlerListState()
    object Loading:TestlerListState()
    object Empty:TestlerListState()
    class Result(val users:List<TestlerEntity>):TestlerListState()
    class Error(val throwable: Throwable? = null):TestlerListState()
}