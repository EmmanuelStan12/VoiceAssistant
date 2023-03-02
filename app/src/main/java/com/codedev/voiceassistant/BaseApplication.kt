package com.codedev.voiceassistant

import android.app.Application
import androidx.viewbinding.BuildConfig
import timber.log.Timber

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (Timber.treeCount == 0 && BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}