package com.timecat.component.commonsdk.utils.override;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.timecat.component.commonsdk.R;

/**
 * @author dlink
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2018/5/11
 * @description null
 * @usage null
 */
public class IntentUtil {
    /**
     * 生产PendingIntent
     */
    public static PendingIntent createPendingIntent(Context context, String packageName, int requestCode, String target) {
        Intent contentIntent = new Intent(target);
        return PendingIntent.getBroadcast(context, requestCode, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    /**
     * 生产PendingIntent
     */
    public static PendingIntent createPendingIntent(Context context, Class<? extends Activity> activity, String action) {
        Intent contentIntent = new Intent(context, activity);
        contentIntent.setAction(action);
        contentIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return PendingIntent.getActivity(context, R.string.app_name, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    /**
     * 生产PendingIntent
     */
    public static PendingIntent createPendingIntent(Context context, Class<? extends Activity> activity) {
        Intent contentIntent = new Intent(context, activity);
        contentIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return PendingIntent.getActivity(context, R.string.app_name, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
