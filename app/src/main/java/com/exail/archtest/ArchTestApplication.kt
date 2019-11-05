package com.exail.archtest

import android.app.Application
import com.exail.archtest.koin.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class ArchTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ArchTestApplication)
            modules(appModules)
        }
    }
}

