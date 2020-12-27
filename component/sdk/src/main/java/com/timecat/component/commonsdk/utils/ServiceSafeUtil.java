package com.timecat.component.commonsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

/**
 * @author dlink
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2018/9/4
 * @description null
 * @usage null
 */
public class ServiceSafeUtil {
    public static void safeStartService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
