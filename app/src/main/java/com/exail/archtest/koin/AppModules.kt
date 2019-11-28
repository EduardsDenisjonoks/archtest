package com.exail.archtest.koin

import android.content.Context
import com.exail.archtest.core.Analytics
import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.dsl.module

/**
 * Created by eduardsdenisjonoks  on 2019-05-21.
 */

val appModules = module {

    single { Analytics(analyticsInstance = getFirebaseAnalyticsInstance(context = get())) }

}

fun getFirebaseAnalyticsInstance(context: Context) = FirebaseAnalytics.getInstance(context)





