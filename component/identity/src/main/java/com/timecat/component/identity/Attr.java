package com.timecat.component.identity;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.timecat.identity.skin.SkinResource;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019-07-28
 * @description null
 * @usage null
 */
public class Attr {

    @ColorInt
    public static int getPrimaryDarkColor(@NonNull Context context) {
        return SkinResource.getColor(context, R.color.master_colorPrimaryDark);
        //        return getColorAttr(context, R.attr.colorPrimaryDark);
    }

    @ColorInt
    public static int getPrimaryColor(@NonNull Context context) {
        //        return getColorAttr(context, R.attr.colorPrimary);
        return SkinResource.getColor(context, R.color.master_colorPrimary);
    }

    @ColorInt
    public static int getPrimaryTextColor(@NonNull Context context) {
        //        return getColorAttr(context, android.R.attr.textColorPrimary);
        return SkinResource.getColor(context, R.color.master_textColorPrimary);
    }

    @ColorInt
    public static int getPrimaryTextColorReverse(@NonNull Context context) {
        //        return getColorAttr(context, android.R.attr.textColorPrimary);
        return SkinResource.getColor(context, R.color.master_textColorPrimary_reverse);
    }

    @ColorInt
    public static int getSecondaryTextColor(@NonNull Context context) {
        //        return getColorAttr(context, android.R.attr.textColorSecondary);
        return SkinResource.getColor(context, R.color.master_textColorSecondary);
    }

    @ColorInt
    public static int getTertiaryTextColor(@NonNull Context context) {
        //        return getColorAttr(context, android.R.attr.textColorTertiary);
        return SkinResource.getColor(context, R.color.master_textColorTertiary);
    }

    @ColorInt
    public static int getAccentColor(@NonNull Context context) {
        //        return getColorAttr(context, R.attr.colorAccent);
        return SkinResource.getColor(context, R.color.master_colorAccent);
    }

    @ColorInt
    public static int getIconColor(@NonNull Context context) {
        //        return getColorAttr(context, R.attr.icon_color);
        return SkinResource.getColor(context, R.color.master_icon_view);
    }

    @ColorInt
    public static int getIconColorReverse(@NonNull Context context) {
        //        return getColorAttr(context, R.attr.icon_color);
        return SkinResource.getColor(context, R.color.master_icon_view_reverse);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @ColorRes int color) {
        return SkinResource.getColor(context, color);
    }

    public static Drawable getWindowBackground(@NonNull Context context) {
        return SkinResource.getDrawable(context, R.drawable.t_window_bg);
    }

    public static Drawable getDrawerBackground(@NonNull Context context) {
        return SkinResource.getDrawable(context, R.drawable.t_drawer_bg);
    }

    public static Drawable getMiniBackground(@NonNull Context context) {
        return SkinResource.getDrawable(context, R.drawable.t_miniplaybar_bg);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int resId) {
        return SkinResource.getDrawable(context, resId);
    }

    public static Drawable tintIcon(Context context, @DrawableRes int resId) {
        Drawable drawable = SkinResource.getDrawable(context, resId);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, getIconColor(context));
        return drawable;
    }

    public static Drawable tint(Context context, @DrawableRes int resId, @ColorRes int colorId) {
        Drawable drawable = SkinResource.getDrawable(context, resId);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, SkinResource.getColor(context, colorId));
        return drawable;
    }

    public static Drawable tintDrawable(Context context, @DrawableRes int resId, @ColorInt int color) {
        Drawable drawable = SkinResource.getDrawable(context, resId);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, color);
        return drawable;
    }

    @ColorInt
    public static int getListDivider(@NonNull Context context) {
        return getColorAttr(context, R.attr.dividerColor);
    }

    @ColorInt
    public static int getCardBackground(@NonNull Context context) {
        return getColorAttr(context, R.attr.card_background);
    }

    @ColorInt
    public static int getTextBackground(@NonNull Context context) {
        return SkinResource.getColor(context, R.color.master_textBackground);
    }

    @ColorInt
    public static int getBackgroundColor(@NonNull Context context) {
        return SkinResource.getColor(context, R.color.master_background);
    }

    @ColorInt
    public static int getBackgroundDarkColor(@NonNull Context context) {
        return SkinResource.getColor(context, R.color.master_background_dark);
    }

    @ColorInt
    public static int getBackgroundDarkestColor(@NonNull Context context) {
        return SkinResource.getColor(context, R.color.master_background_darkest);
    }

    @ColorInt
    public static int getBackgroundReverseColor(@NonNull Context context) {
        return SkinResource.getColor(context, R.color.master_background_reverse);
    }

    @ColorInt
    public static int getPatchAdditionColor(@NonNull Context context) {
        return getColorAttr(context, R.attr.patch_addition);
    }

    @ColorInt
    public static int getPatchDeletionColor(@NonNull Context context) {
        return getColorAttr(context, R.attr.patch_deletion);
    }

    @ColorInt
    public static int getPatchRefColor(@NonNull Context context) {
        return getColorAttr(context, R.attr.patch_ref);
    }

    @ColorInt
    private static int getColorAttr(@NonNull Context context, int attr) {
        Resources.Theme theme = context.getTheme();
        TypedArray typedArray = theme.obtainStyledAttributes(new int[]{attr});
        final int color = typedArray.getColor(0, Color.LTGRAY);
        typedArray.recycle();
        return color;
    }
}
