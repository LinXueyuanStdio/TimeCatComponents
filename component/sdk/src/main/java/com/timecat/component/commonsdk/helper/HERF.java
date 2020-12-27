package com.timecat.component.commonsdk.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.timecat.extend.arms.BaseApplication;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/10/7
 * @description null
 * @usage null
 */
public class HERF {
    public static void gotoUrl(Context context, String url) {
        Intent intent = new Intent();
        intent.setClassName("com.time.cat", "acr.browser.lightning.MainActivity");
        if (url != null && !url.isEmpty()) {
            intent.setData(Uri.parse(url));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (context != null) {
            context.startActivity(intent);
        } else {
            BaseApplication.getContext().startActivity(intent);
        }
    }
}
