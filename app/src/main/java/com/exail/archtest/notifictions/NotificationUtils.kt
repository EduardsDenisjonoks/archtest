package com.exail.archtest.notifictions

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.exail.archtest.R
import com.exail.archtest.core.getResString
import timber.log.Timber
import java.lang.Exception
import java.util.*

class NotificationUtils {

    companion object {
        private const val CONTENT_NOTIFICATION_ID: Int = 1000

        fun showContentNotification(context: Context, title: String, content: String) {
            val builder =
                createNotification(context = context, icon = null, title = title, content = content)
            with(NotificationManagerCompat.from(context)) {
                notify(CONTENT_NOTIFICATION_ID, builder.build())
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
            title?.let { this.setContentTitle(title) }
            content?.let { this.setContentText(content) }
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

