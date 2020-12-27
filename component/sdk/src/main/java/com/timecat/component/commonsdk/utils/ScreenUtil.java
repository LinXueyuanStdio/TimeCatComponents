package com.timecat.component.commonsdk.utils;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * https://github.com/guoyoujin/MySnackBar
 */

public class ScreenUtil {

  private ScreenUtil() {
    /* cannot be instantiated */
    throw new UnsupportedOperationException("cannot be instantiated");
  }

  public static int dp2px(Context ctx, float dpValue) {
    final float density = ctx.getResources().getDisplayMetrics().density;
    return (int) (dpValue * density + 0.5f);
  }

  public static int sp2px(Context ctx, float spValue) {
    final float scaledDensity = ctx.getResources().getDisplayMetrics().scaledDensity;
    return (int) (spValue * scaledDensity + 0.5f);
  }

  /**
   * 获取屏幕的宽度
   */
  public static int getScreenWidth(Context context) {
    WindowManager manager = (WindowManager) context
        .getSystemService(Context.WINDOW_SERVICE);
    Display display = manager.getDefaultDisplay();
    return display.getWidth();
  }

  /**
   * 获取屏幕的高度
   */
  public static int getScreenHeight(Context context) {
    WindowManager manager = (WindowManager) context
        .getSystemService(Context.WINDOW_SERVICE);
    Display display = manager.getDefaultDisplay();
    return display.getHeight();
  }

  /**
   * 设置view margin
   */
  public static void setMargins(View v, int l, int t, int r, int b) {
    if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
      ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
      p.setMargins(l, t, r, b);
      v.requestLayout();
    }
  }

}
