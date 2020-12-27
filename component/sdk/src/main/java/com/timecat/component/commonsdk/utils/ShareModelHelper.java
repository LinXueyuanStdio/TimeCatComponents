package com.timecat.component.commonsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;

import androidx.annotation.StringRes;
import androidx.core.content.FileProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dlink
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019/2/19
 * @description null
 * @usage null
 */
public class ShareModelHelper {
    public static void share(Context context, String title, String content, List<Uri> uris, @StringRes int titlestring) {
        Intent shareIntent = new Intent();
        if (uris == null || uris.size() == 0) {
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
        } else if (uris.size() == 1) {
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("*/*");
            shareIntent.putExtra(Intent.EXTRA_STREAM, uris.get(0));
        } else {
            shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
            shareIntent.setType("*/*");
            shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, (ArrayList<? extends Parcelable>) uris);
        }
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);

        context.startActivity(Intent.createChooser(shareIntent,
                context.getResources().getString(titlestring)));
    }

    public static void shareFile(Context context, File file, String mimeType, @StringRes int title) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType(mimeType);
        shareIntent.putExtra(Intent.EXTRA_STREAM, getUriFromFile(context, file));
        context.startActivity(Intent.createChooser(shareIntent, context.getResources().getString(title)));
    }

    public static Uri getUriFromFile(Context context, File file) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            return FileProvider.getUriForFile(context, "com.time.cat.file.provider", file);
        } else {
            return Uri.fromFile(file);
        }
    }
}