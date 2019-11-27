package com.exail.archtest

import android.app.Application
import android.util.Log
import com.exail.archtest.core.LogUtils
import com.exail.archtest.koin.appModules
import com.exail.archtest.koin.networkModule
import com.exail.archtest.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */
class ArchTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ArchTestApplication)
            modules(appModules, networkModule, viewModelModule)
        }
        Timber.plant(if (BuildConfig.DEBUG) DebugTree() else ProductionTree())
    }
}

class ProductionTree : Timber.Tree() {
    override fun isLoggable(tag: String?, priority: Int) =
        priority == Log.ERROR || priority == Log.WARN

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) =
        when (priority) {
            Log.ERROR -> LogUtils.error(tag ?: "", message, t)
            Log.WARN -> LogUtils.warn(tag ?: "", message, t)
            else -> LogUtils.debug(tag ?: "", message, t)
        }
}

class DebugTree : Timber.DebugTree() {
    override fun isLoggable(tag: String?, priority: Int) = true

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) =
        when (priority) {
            Log.DEBUG -> LogUtils.debug(tag ?: "", message, t)
            Log.ERROR -> LogUtils.error(tag ?: "", message, t)
            Log.WARN -> LogUtils.warn(tag ?: "", message, t)
            Log.INFO -> LogUtils.info(tag ?: "", message, t)
            Log.VERBOSE -> LogUtils.verbose(tag ?: "", message, t)
            else -> LogUtils.debug(tag ?: "", message, t)
        }
}

