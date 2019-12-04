package com.exail.archtest.core

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class Analytics(private val analyticsInstance: FirebaseAnalytics) {

    /**
     * Apply required string length limitation for FirebaseAnalytics parameters
     */
    private fun String.limit(charLimit: Int = 99) =
        if (this.length > charLimit) this.substring(0..charLimit) else this

    private fun logEvent(event: String = AnalyticsEvents.EVENT, bundle: Bundle? = null) {
        analyticsInstance.logEvent(event.limit(), bundle)
    }

    fun eventOpenCatScreen() {
        logEvent(event = AnalyticsEvents.CAT)
    }

    fun eventOpenCatPaginatedScreen() {
        logEvent(event = AnalyticsEvents.CAT_PAGINATED)
    }

    fun eventOpenChuckNorrisScreen() {
        logEvent(event = AnalyticsEvents.CHUCK_NORRIS)
    }

    fun eventOpenStarWardScreen() {
        logEvent(event = AnalyticsEvents.SW)
    }

    fun eventViewBottomNavFragment(index: Int) {
        val bundle = Bundle()
        bundle.putInt(AnalyticsParams.FRAGMENT_INDEX, index)
        logEvent(AnalyticsEvents.BOTTOM_NAV, bundle)
    }
}

sealed class AnalyticsEvents {

    companion object {
        const val EVENT = "EVENT"
        const val CAT = "CAT"
        const val CAT_PAGINATED = "CAT_PAGINATED"
        const val CHUCK_NORRIS = "CHUCK_NORRIS"
        const val SW = "STAR_WARS"
        const val BOTTOM_NAV = "BOTTOM_NAV"
    }
}

sealed class AnalyticsParams {

    companion object {
        const val FRAGMENT_INDEX = "FRAGMENT_INDEX"
    }
}