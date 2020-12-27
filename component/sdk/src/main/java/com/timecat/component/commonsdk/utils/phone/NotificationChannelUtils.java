package com.timecat.component.commonsdk.utils.phone;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import com.timecat.extend.arms.BaseApplication;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * @author dlink
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019/1/1
 * @description null
 * @usage null
 */
public class NotificationChannelUtils {
    public static void createNotificationChannel(Context context, String channelID) {
        //create a notification channel
        NotificationManager notificationManager = getNotificationManager(context);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            final NotificationChannel defaultChannel = new NotificationChannel(
                    channelID, channelID, NotificationManager.IMPORTANCE_MIN);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(defaultChannel);
            }
        }
    }

    public static NotificationManager getNotificationManager(Context context) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            return (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        }
        return (NotificationManager) BaseApplication.getInstance().getSystemService(NOTIFICATION_SERVICE);

    }
}
