package com.timecat.component.commonsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

import com.timecat.identity.font.FontAwesome;

public abstract class InterfaceUtils {
    @Nullable
    private static Float fixedResolution = null;

    public static void setFixedResolution(@NonNull Float f) {
        fixedResolution = f;
    }

    public static Typeface getFontAwesome(Context context) {
        return FontAwesome.getFontAwesome(context);
    }

    public static float dpToPixels(Context context, float dp) {
        if (fixedResolution != null) return dp * fixedResolution;

        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics);
    }

    public static float spToPixels(Context context, float sp) {
        if (fixedResolution != null) return sp * fixedResolution;

        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, metrics);
    }

    public static float getDimension(Context context, int id) {
        float dim = context.getResources().getDimension(id);
        if (fixedResolution == null) return dim;
        else {
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            float actualDensity = dm.density;
            return dim / actualDensity * fixedResolution;
        }
    }

    public static void setupEditorAction(@NonNull ViewGroup parent,
                                         @NonNull TextView.OnEditorActionListener listener) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);

            if (child instanceof ViewGroup)
                setupEditorAction((ViewGroup) child, listener);

            if (child instanceof TextView)
                ((TextView) child).setOnEditorActionListener(listener);
        }
    }

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.getLayoutDirection(view) ==
                ViewCompat.LAYOUT_DIRECTION_RTL;
    }
}
