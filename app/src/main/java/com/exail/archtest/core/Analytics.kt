package com.exail.archtest.core

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class Analytics(private val analyticsInstance: FirebaseAnalytics) {

    private fun logEvent(event: String = AnalyticsEvents.EVENT, bundle: Bundle? = null) {
        analyticsInstance.logEvent(event, bundle)
    }

    fun eventOpenCatScreen(){
        logEvent(event = AnalyticsEvents.CAT)
    }

    fun eventOpenCatPaginatedScreen(){
        logEvent(event = AnalyticsEvents.CAT_PAGINATED)
    }

    fun eventOpenChuckNorrisScreen(){
        logEvent(event = AnalyticsEvents.CHUCK_NORRIS)
    }

    fun eventOpenStarWardScreen(){
        logEvent(event = AnalyticsEvents.SW)
    }
}

sealed class AnalyticsEvents {

    companion object {
        const val EVENT = "EVENT"
        const val CAT = "CAT"
        const val CAT_PAGINATED = "CAT_PAGINATED"
        const val CHUCK_NORRIS = "CHUCK_NORRIS"
        const val SW = "STAR_WARS"
    }
}