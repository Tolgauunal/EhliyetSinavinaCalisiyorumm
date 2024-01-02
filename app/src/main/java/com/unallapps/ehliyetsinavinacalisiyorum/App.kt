package com.unallapps.ehliyetsinavinacalisiyorum

import android.app.Application
import androidx.room.Room
import com.unallapps.ehliyetsinavinacalisiyorum.data.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application() {
    companion object {
        lateinit var instance: App
            private set

        fun isInstanceInitialized() = ::instance.isInitialized
    }
}