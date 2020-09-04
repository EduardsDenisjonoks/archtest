package com.exail.archtest.notifictions

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.Navigation
import com.exail.archtest.MainActivity
import com.exail.archtest.R
import com.exail.archtest.bottom.BottomNavActivity
import com.exail.archtest.core.getResString
import com.exail.archtest.sw.models.People
import com.exail.archtest.sw.people.PeopleFragmentDirections
import timber.log.Timber
import java.lang.Exception
import java.util.*

class NotificationUtils {

    companion object {
        private const val CONTENT_LIMIT: Int = 50
        private const val CONTENT_NOTIFICATION_ID: Int = 1000
        private const val DEEP_LINK_NOTIFICATION_ID: Int = 1001

        fun showContentNotification(context: Context, title: String, content: String) {
            val builder =
                createNotification(context = context, icon = null, title = title, content = content)
            with(NotificationManagerCompat.from(context)) {
                notify(CONTENT_NOTIFICATION_ID, builder.build())
            }
        }

        fun showDeepLinkNotification(context: Context) {
            val builder =
                createNotification(
                    context = context,
                    icon = null,
                    title = "Deep link notification",
                    content = "This notification will take you into test bottom navigation: fragment five"
                )

            val pendingIntent = NavDeepLinkBuilder(context)
                .setComponentName(BottomNavActivity::class.java)
                .setGraph(R.navigation.nav_bottom)
                .setDestination(R.id.navigation_five)
                .createPendingIntent()
/*
            val pendingIntent = NavDeepLinkBuilder(context)
                .setGraph(R.navigation.nav_main)
                .setDestination(R.id.personFragment)
                .setArguments(PeopleFragmentDirections.actionPeoplesFragmentToPersonFragment(People(1, "Ed", "Male", "1992", "Blue", "Brown", "White", "181 cm", "120kg", 1, emptyList(),
                    emptyList(), emptyList())).arguments)
                .createPendingIntent()*/

            builder.setContentIntent(pendingIntent)

            with(NotificationManagerCompat.from(context)) {
                notify(DEEP_LINK_NOTIFICATION_ID, builder.build())
            }
        }

        private fun createNotification(
            context: Context,
            icon: Int?,
            title: String,
            content: String
        ): NotificationCompat.Builder {
            val channelId = createNotificationChannel(context)
            val builder = NotificationCompat.Builder(context, channelId)
                .setContent(icon, title, content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            return builder
        }

        private fun createNotification(
            context: Context,
            icon: Int?,
            title: Int?,
            content: Int?
        ): NotificationCompat.Builder {
            val channelId = createNotificationChannel(context)
            val builder = NotificationCompat.Builder(context, channelId)
                .setContent(icon, title, content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            return builder
        }

        private fun createNotificationChannel(
            context: Context,
            chanelId: String = "default",
            name: String? = "default",
            description: String? = null,
            importance: Int? = null
        ): String {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel =
                    NotificationChannel(
                        chanelId,
                        name,
                        importance ?: NotificationManager.IMPORTANCE_DEFAULT
                    ).apply { description?.let { this.description = description } }
                val notificationManager: NotificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
            return chanelId
        }

        private fun NotificationCompat.Builder.setContent(
            @DrawableRes icon: Int?,
            title: String? = null,
            content: String? = null
        ): NotificationCompat.Builder {
            this.setSmallIcon(icon ?: R.mipmap.ic_launcher)
            title?.let { this.setContentTitle(it) }
            content?.let {
                this.setContentText(it)
                if (it.length >= CONTENT_LIMIT) {
                    this.setStyle(NotificationCompat.BigTextStyle().bigText(it))
                } else {
                    this.setContentText(it)
                }

            }
            return this
        }


        private fun NotificationCompat.Builder.setContent(
            @DrawableRes icon: Int?,
            @StringRes title: Int? = null,
            @StringRes content: Int? = null
        ): NotificationCompat.Builder {
            return this.setContent(
                icon,
                title.getResString(mContext),
                content.getResString(mContext)
            )
        }
    }
}

