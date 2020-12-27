package com.timecat.component.commonsdk.utils.override;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.timecat.extend.arms.BaseApplication;
import com.timecat.component.commonsdk.BuildConfig;


public class LogUtil {

    public static final String tag = "TimeCat";
    public static boolean isEshow = true;
    public static boolean isWshow = true;
    public static boolean isIshow = true;
    public static boolean isDshow = true;
    public static boolean isVshow = true;

    static {
        if (isApkDebugable(BaseApplication.getContext())) {
            isEshow = true;
            isWshow = true;
            isIshow = true;
            isDshow = true;
            isVshow = true;
        } else {
            isEshow = true;
            isWshow = false;
            isIshow = false;
            isDshow = false;
            isVshow = false;
        }
    }

    public static boolean isApkDebugable(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) == ApplicationInfo.FLAG_DEBUGGABLE;
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * true:打开log  false:关闭所有的日志
     */
    public static boolean OPEN_LOG = BuildConfig.LOG_DEBUG;

    /**
     * true : 打开debug 日志  false:关闭debug日志
     */
    public static boolean DEBUG = BuildConfig.LOG_DEBUG;

    private String mClassName;
    private static LogUtil log;
    private static final String USER_NAME = "@lxy ";

    private LogUtil(String name) {
        mClassName = name;
    }

    public static void i(Object str) {
        print(Log.INFO, str, false);
    }

    public static void d(Object str) {
        print(Log.DEBUG, str, false);
    }

    public static void v(Object str) {
        print(Log.VERBOSE, str, false);
    }

    public static void w(Object str) {
        print(Log.WARN, str, false);
    }

    public static void e(Object str) {
        print(Log.ERROR, str, false);
    }

    public static void i(Object str, Object str2) {
        print(Log.INFO, str + ", " + str2, false);
    }

    public static void d(Object str, Object str2) {
        print(Log.DEBUG, str + ", " + str2, false);
    }

    public static void v(Object str, Object str2) {
        print(Log.VERBOSE, str + ", " + str2, false);
    }

    public static void w(Object str, Object str2) {
        print(Log.WARN, str + ", " + str2, false);
    }

    public static void e(Object str, Object str2) {
        print(Log.ERROR, str + ", " + str2, false);
    }


    public static void si(Object str) {
        print(Log.INFO, str, true);
    }

    public static void sd(Object str) {
        print(Log.DEBUG, str, true);
    }

    public static void sv(Object str) {
        print(Log.VERBOSE, str, true);
    }

    public static void sw(Object str) {
        print(Log.WARN, str, true);
    }

    public static void se(Object str) {
        print(Log.ERROR, str, true);
    }

    /**
     * 用于区分不同接口数据 打印传入参数
     *
     * @param index
     * @param str
     */
    private static void print(int index, Object str, boolean isShort) {
        if (!OPEN_LOG) {
            return;
        }
        if (log == null) {
            log = new LogUtil(USER_NAME);
        }
        StringBuilder builder = new StringBuilder();
        if (isShort) {
            builder.append("\n┆ " + log.mClassName + " - " + generateLog());
            builder.append(String.format("%s", str));
        } else {
            builder.append("\n┆ Thread:" + getThreadInfo() + " - " + log.mClassName + " - " + generateLog());
            builder.append("\n┆ " + String.format("%s", str));
            builder.append("\n└──────────────────────────────────────────────────────────────────────────");
        }

        // Close the debug log When DEBUG is false
        if (!DEBUG) {
            if (index <= Log.DEBUG) {
                return;
            }
        }
        switch (index) {
            case Log.VERBOSE:
                Log.v(tag, builder.toString());
                break;
            case Log.DEBUG:
                Log.d(tag, builder.toString());
                break;
            case Log.INFO:
                Log.i(tag, builder.toString());
                break;
            case Log.WARN:
                Log.w(tag, builder.toString());
                break;
            case Log.ERROR:
                Log.e(tag, builder.toString());
                break;
            default:
                Log.i(tag, builder.toString());
                break;
        }
    }

    /**
     * 根据堆栈信息定位 Log
     * 生成 Log 为 类名 + 方法名 + 行数
     *
     * @return 返回 Log
     */
    private static String generateLog() {
        StackTraceElement element = getCallerStackTraceElement();

        String log = "%s.%s (%s:%d)";
        // 获取堆栈信息中调用当前方法的类名
        String className = element.getClassName();
        // 截取简单类名
        className = className.substring(className.lastIndexOf(".") + 1);
        // 格式化 log 内容
        log = String.format(log, className, element.getMethodName(), element.getFileName(), element.getLineNumber());
        return log;
    }

    /**
     * StackTrace用栈的形式保存了方法的调用信息；
     * 可用 Thread.currentThread().getStackTrace()方法得到当前线程的 StackTrace 信息；
     * 该方法返回的是一个 StackTraceElement 数组；
     * <p/>
     * 在 StackTraceElement 数组下标为[2]的元素中保存了当前方法的所属文件名，当前方法所属的类名,
     * 以及该方法的名字；除此以外还可以获取方法调用的行数；
     * 在 StackTraceElement 数组下标为[3]的元素中保存了当前方法的调用者的信息和它调用时的代码行数；
     */
    private static StackTraceElement getCallerStackTraceElement() {
        // 所以这里选择第三个元素，用来获取调用当前方法的类和方法名以及行数
        return Thread.currentThread().getStackTrace()[6];
    }

    /**
     * 获取线程信息
     */
    private static String getThreadInfo() {
        String threadName = Thread.currentThread().getName();
        long threadId = Thread.currentThread().getId();
        return threadName + " - " + threadId;
    }

}
