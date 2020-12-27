package com.timecat.component.commonsdk.utils.string;

import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;
import com.timecat.extend.arms.BaseApplication;
import com.timecat.component.commonsdk.utils.date.DateUtil;
import com.timecat.component.commonsdk.utils.override.LogUtil;

import org.joda.time.DateTime;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dlink
 * @date 2018/2/2
 * @description 通用字符串(String)相关类, 为null时返回"",调用方法为StringUtil.xxxMethod(...);
 */
public class StringUtil {
    public static final String HTTP = "http";
    public static final String URL_PREFIX = "http://";
    public static final String URL_PREFIXs = "https://";


    //获取string,为null时返回"" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public static final String URL_STAFFIX = URL_PREFIX;
    public static final String URL_STAFFIXs = URL_PREFIXs;
    public static final String FILE_PATH_PREFIX = "file://";
    public static final int PRICE_FORMAT_DEFAULT = 0;
    public static final int PRICE_FORMAT_PREFIX = 1;
    public static final int PRICE_FORMAT_SUFFIX = 2;
    public static final int PRICE_FORMAT_PREFIX_WITH_BLANK = 3;
    public static final int PRICE_FORMAT_SUFFIX_WITH_BLANK = 4;

    //获取string,为null时返回"" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //获取去掉前后空格后的string<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public static final String[] PRICE_FORMATS = {"", "￥", "元", "￥ ", " 元"};
    private static final String TAG = "StringUtil";
    private static String currentString = "";

    /**
     * 获取刚传入处理后的string
     *
     * @return
     * @must 上个影响currentString的方法 和 这个方法都应该在同一线程中，否则返回值可能不对
     */
    public static String getCurrentString() {
        return currentString == null ? "" : currentString;
    }

    /**
     * 获取string,为null则返回""
     *
     * @param tv
     * @return
     */
    public static String get(TextView tv) {
        if (tv == null || tv.getText() == null) {
            return "";
        }
        return tv.getText().toString();
    }

    /**
     * 获取string,为null则返回""
     *
     * @param object
     * @return
     */
    public static String get(Object object) {
        return object == null ? "" : object.toString();
    }

    /**
     * 获取string,为null则返回""
     *
     * @param cs
     * @return
     */
    public static String get(CharSequence cs) {
        return cs == null ? "" : cs.toString();
    }

    /**
     * 获取string,为null则返回""
     *
     * @param s
     * @return
     */
    public static String get(String s) {
        return s == null ? "" : s;
    }

    //获取去掉前后空格后的string>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //获取去掉所有空格后的string <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    /**
     * deprecated 用get代替，这个保留到17.0
     */
    public static String getString(TextView tv) {
        return get(tv);
    }

    /**
     * deprecated 用get代替，这个保留到17.0
     */
    public static String getString(Object object) {
        return get(object);
    }

    /**
     * deprecated 用get代替，这个保留到17.0
     */
    public static String getString(CharSequence cs) {
        return get(cs);
    }

    /**
     * deprecated 用get代替，这个保留到17.0
     */
    public static String getString(String s) {
        return get(s);
    }

    /**
     * 获取去掉前后空格后的string,为null则返回""
     *
     * @param tv
     * @return
     */
    public static String trim(TextView tv) {
        return trim(get(tv));
    }

    /**
     * 获取去掉前后空格后的string,为null则返回""
     *
     * @param object
     * @return
     */
    public static String trim(Object object) {
        return trim(get(object));
    }

    /**
     * 获取去掉前后空格后的string,为null则返回""
     *
     * @param cs
     * @return
     */
    public static String trim(CharSequence cs) {
        return trim(get(cs));
    }

    /**
     * 获取去掉前后空格后的string,为null则返回""
     *
     * @param s
     * @return
     */
    public static String trim(String s) {
        return s == null ? "" : s.trim();
    }

    //获取去掉所有空格后的string >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //获取string的长度<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    /**
     * deprecated 用trim代替，这个保留到17.0
     */
    public static String getTrimedString(TextView tv) {
        return trim(tv);
    }

    /**
     * deprecated 用trim代替，这个保留到17.0
     */
    public static String getTrimedString(Object object) {
        return trim(object);
    }

    /**
     * deprecated 用trim代替，这个保留到17.0
     */
    public static String getTrimedString(CharSequence cs) {
        return trim(get(cs));
    }

    /**
     * deprecated 用trim代替，这个保留到17.0
     */
    public static String getTrimedString(String s) {
        return trim(s);
    }

    /**
     * 获取去掉所有空格后的string,为null则返回""
     *
     * @param tv
     * @return
     */
    public static String noBlank(TextView tv) {
        return noBlank(get(tv));
    }

    /**
     * 获取去掉所有空格后的string,为null则返回""
     *
     * @param object
     * @return
     */
    public static String noBlank(Object object) {
        return noBlank(get(object));
    }

    /**
     * 获取去掉所有空格后的string,为null则返回""
     *
     * @param cs
     * @return
     */
    public static String noBlank(CharSequence cs) {
        return noBlank(get(cs));
    }

    /**
     * 获取去掉所有空格后的string,为null则返回""
     *
     * @param s
     * @return
     */
    public static String noBlank(String s) {
        return get(s).replaceAll(" ", "");
    }

    //获取string的长度>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //判断字符是否为空 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    /**
     * deprecated 用noBlank代替，这个保留到17.0
     */
    public static String getNoBlankString(TextView tv) {
        return noBlank(get(tv));
    }

    /**
     * deprecated 用noBlank代替，这个保留到17.0
     */
    public static String getNoBlankString(Object object) {
        return noBlank(get(object));
    }

    /**
     * deprecated 用noBlank代替，这个保留到17.0
     */
    public static String getNoBlankString(CharSequence cs) {
        return noBlank(get(cs));
    }

    /**
     * deprecated 用noBlank代替，这个保留到17.0
     */
    public static String getNoBlankString(String s) {
        return noBlank(s);
    }

    /**
     * 获取string的长度,为null则返回0
     *
     * @param tv
     * @return
     */
    public static int length(TextView tv) {
        return length(get(tv));
    }
    //判断字符是否为空 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //判断字符是否非空 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    /**
     * 获取string的长度,为null则返回0
     *
     * @param object
     * @return
     */
    public static int length(Object object) {
        return length(get(object));
    }

    /**
     * 获取string的长度,为null则返回0
     *
     * @param cs
     * @return
     */
    public static int length(CharSequence cs) {
        return length(get(cs));
    }

    /**
     * 获取string的长度,为null则返回0
     *
     * @param s
     * @return
     */
    public static int length(String s) {
        return get(s).length();
    }

    /**
     * deprecated 用length代替，这个保留到17.0
     */
    public static int getLength(TextView tv, boolean trim) {
        return getLength(get(tv), trim);
    }

    //判断字符是否非空 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //判断字符类型 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    /**
     * deprecated 用length代替，这个保留到17.0
     */
    public static int getLength(Object object, boolean trim) {
        return getLength(get(object), trim);
    }

    /**
     * deprecated 用length代替，这个保留到17.0
     */
    public static int getLength(CharSequence cs, boolean trim) {
        return getLength(get(cs), trim);
    }

    /**
     * deprecated 用length代替，这个保留到17.0
     */
    public static int getLength(String s, boolean trim) {
        s = trim ? getTrimedString(s) : s;
        return length(s);
    }

    /**
     * 判断字符是否为空
     * trim = true
     *
     * @param text text
     * @return string
     */
    public static boolean isEmpty(@Nullable String text) {
        return text == null || TextUtils.isEmpty(text) || isWhiteSpaces(text) || text.equalsIgnoreCase("null");
    }

    public static boolean isEmpty(@Nullable Object text) {
        return text == null || isEmpty(text.toString());
    }

    public static boolean isEmpty(@Nullable EditText text) {
        return text == null || isEmpty(text.getText().toString());
    }

    public static boolean isEmpty(@Nullable TextView text) {
        return text == null || isEmpty(text.getText().toString());
    }

    public static boolean isEmpty(@Nullable TextInputLayout txt) {
        return txt == null || isEmpty(txt.getEditText());
    }


    /**
     * 判断字符是否为空
     *
     * @param tv
     * @param trim
     * @return
     */
    public static boolean isEmpty(TextView tv, boolean trim) {
        return isEmpty(get(tv), trim);
    }

    /**
     * 判断字符是否为空
     *
     * @param object
     * @param trim
     * @return
     */
    public static boolean isEmpty(Object object, boolean trim) {
        return isEmpty(get(object), trim);
    }

    /**
     * 判断字符是否为空
     *
     * @param cs
     * @param trim
     * @return
     */
    public static boolean isEmpty(CharSequence cs, boolean trim) {
        return isEmpty(get(cs), trim);
    }

    /**
     * 判断字符是否为空
     *
     * @param s
     * @param trim
     * @return
     */
    public static boolean isEmpty(String s, boolean trim) {
        //		Log.i(TAG, "isEmpty   s = " + s);
        if (s == null) {
            return true;
        }
        if (trim) {
            s = s.trim();
        }
        if (s.length() <= 0) {
            return true;
        }

        currentString = s;

        return false;
    }

    /**
     * 判断字符是否非空
     *
     * @param tv
     * @param trim
     * @return
     */
    public static boolean isNotEmpty(TextView tv, boolean trim) {
        return isNotEmpty(get(tv), trim);
    }

    /**
     * 判断字符是否非空
     *
     * @param object
     * @param trim
     * @return
     */
    public static boolean isNotEmpty(Object object, boolean trim) {
        return isNotEmpty(get(object), trim);
    }

    /**
     * 判断字符是否非空
     *
     * @param cs
     * @param trim
     * @return
     */
    public static boolean isNotEmpty(CharSequence cs, boolean trim) {
        return isNotEmpty(get(cs), trim);
    }

    /**
     * 判断字符是否非空
     *
     * @param s
     * @param trim
     * @return
     */
    public static boolean isNotEmpty(String s, boolean trim) {
        return !isEmpty(s, trim);
    }

    //判断手机格式是否正确
    public static boolean isPhone(String phone) {
        if (isEmpty(phone, true)) {
            return false;
        }

        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-2,5-9])|(17[0-9]))\\d{8}$");

        currentString = phone;

        return p.matcher(phone).matches();
    }

    //判断email格式是否正确
    public static boolean isEmail(String email) {
        if (isEmpty(email, true)) {
            return false;
        }

        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);

        currentString = email;

        return p.matcher(email).matches();
    }

    /**
     * deprecated，保留到17.0
     */
    public static boolean isNumer(String number) {
        return isNumber(number);
    }

    //判断字符类型 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //提取特殊字符<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //判断是否全是数字
    public static boolean isNumber(String number) {
        if (isEmpty(number, true)) {
            return false;
        }

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(number);
        if (isNum.matches() == false) {
            return false;
        }

        currentString = number;

        return true;
    }

    /**
     * 判断字符类型是否是号码或字母
     *
     * @param s
     * @return
     */
    public static boolean isNumberOrAlpha(String s) {
        if (s == null) {
            LogUtil.e("isNumberOrAlpha  s == null >> return false;");
            return false;
        }
        Pattern pNumber = Pattern.compile("[0-9]*");
        Matcher mNumber;
        Pattern pAlpha = Pattern.compile("[a-zA-Z]");
        Matcher mAlpha;
        for (int i = 0; i < s.length(); i++) {
            mNumber = pNumber.matcher(s.substring(i, i + 1));
            mAlpha = pAlpha.matcher(s.substring(i, i + 1));
            if (!mNumber.matches() && !mAlpha.matches()) {
                return false;
            }
        }

        currentString = s;
        return true;
    }

    /**
     * 判断字符类型是否是身份证号
     *
     * @param idCard
     * @return
     */
    public static boolean isIDCard(String idCard) {
        if (isNumberOrAlpha(idCard) == false) {
            return false;
        }
        idCard = get(idCard);
        if (idCard.length() == 15) {
            Log.w(TAG, "isIDCard idCard.length() == 15 old IDCard");
            currentString = idCard;
            return true;
        }
        if (idCard.length() == 18) {
            currentString = idCard;
            return true;
        }

        return false;
    }

    /**
     * 判断字符类型是否是网址
     *
     * @param url
     * @return
     */
    public static boolean isUrl(String url) {
        if (isEmpty(url, true)) {
            return false;
        } else if (!url.startsWith(URL_PREFIX) && !url.startsWith(URL_PREFIXs)) {
            return false;
        }

        currentString = url;
        return true;
    }

    //提取特殊字符>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //校正（自动补全等）字符串<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    /**
     * 判断文件路径是否存在
     *
     * @param path
     * @return
     */
    public static boolean isFilePathExist(String path) {
        return StringUtil.isFilePath(path) && new File(path).exists();
    }

    /**
     * 判断字符类型是否是路径
     *
     * @param path
     * @return
     */
    public static boolean isFilePath(String path) {
        if (isEmpty(path, true)) {
            return false;
        }

        if (!path.contains(".") || path.endsWith(".")) {
            return false;
        }

        currentString = path;

        return true;
    }

    /**
     * 去掉string内所有非数字类型字符
     *
     * @param tv tv
     * @return
     */
    public static String getNumber(TextView tv) {
        return getNumber(get(tv));
    }

    /**
     * 去掉string内所有非数字类型字符
     *
     * @param object object
     * @return
     */
    public static String getNumber(Object object) {
        return getNumber(get(object));
    }

    /**
     * 去掉string内所有非数字类型字符
     *
     * @param cs cs
     * @return
     */
    public static String getNumber(CharSequence cs) {
        return getNumber(get(cs));
    }

    /**
     * 去掉string内所有非数字类型字符
     *
     * @param s s
     * @return
     */
    public static String getNumber(String s) {
        if (isEmpty(s, true)) {
            return "";
        }

        String numberString = "";
        String single;
        for (int i = 0; i < s.length(); i++) {
            single = s.substring(i, i + 1);
            if (isNumer(single)) {
                numberString += single;
            }
        }

        return numberString;
    }

    /**
     * 获取网址，自动补全
     *
     * @param tv tv
     * @return
     */
    public static String getCorrectUrl(TextView tv) {
        return getCorrectUrl(get(tv));
    }

    /**
     * 获取网址，自动补全
     *
     * @param url url
     * @return
     */
    public static String getCorrectUrl(String url) {
        Log.i(TAG, "getCorrectUrl : \n" + url);
        if (isEmpty(url, true)) {
            return "";
        }

//		if (! url.endsWith("/") && ! url.endsWith(".html")) {
//			url = url + "/";
//		}

        return isUrl(url) ? url : URL_PREFIX + url;
    }

    /**
     * 获取去掉所有 空格 、"-" 、"+86" 后的phone
     *
     * @param tv tv
     * @return
     */
    public static String getCorrectPhone(TextView tv) {
        return getCorrectPhone(get(tv));
    }

    /**
     * 获取去掉所有 空格 、"-" 、"+86" 后的phone
     *
     * @param phone phone
     * @return
     */
    public static String getCorrectPhone(String phone) {
        if (isEmpty(phone, true)) {
            return "";
        }

        phone = noBlank(phone);
        phone = phone.replaceAll("-", "");
        if (phone.startsWith("+86")) {
            phone = phone.substring(3);
        }
        return phone;
    }

    /**
     * 获取邮箱，自动补全
     *
     * @param tv tv
     * @return
     */
    public static String getCorrectEmail(TextView tv) {
        return getCorrectEmail(get(tv));
    }

    /**
     * 获取邮箱，自动补全
     *
     * @param email email
     * @return
     */
    public static String getCorrectEmail(String email) {
        if (isEmpty(email, true)) {
            return "";
        }

        email = noBlank(email);
        if (isEmail(email) == false && !email.endsWith(".com")) {
            email += ".com";
        }

        return email;
    }

    /**
     * 获取价格，保留两位小数
     *
     * @param price price
     * @return
     */
    public static String getPrice(String price) {
        return getPrice(price, PRICE_FORMAT_DEFAULT);
    }

    /**
     * 获取价格，保留两位小数
     *
     * @param price      price
     * @param formatType 添加单位（元）
     * @return
     */
    public static String getPrice(String price, int formatType) {
        if (isEmpty(price, true)) {
            return getPrice(0, formatType);
        }

        //单独写到getCorrectPrice? <<<<<<<<<<<<<<<<<<<<<<
        String correctPrice = "";
        String s;
        for (int i = 0; i < price.length(); i++) {
            s = price.substring(i, i + 1);
            if (".".equals(s) || isNumer(s)) {
                correctPrice += s;
            }
        }
        //单独写到getCorrectPrice? >>>>>>>>>>>>>>>>>>>>>>

        Log.i(TAG, "getPrice  <<<<<<<<<<<<<<<<<< correctPrice =  " + correctPrice);
        if (correctPrice.contains(".")) {
//			if (correctPrice.startsWith(".")) {
//				correctPrice = 0 + correctPrice;
//			}
            if (correctPrice.endsWith(".")) {
                correctPrice = correctPrice.replaceAll(".", "");
            }
        }

        Log.i(TAG, "getPrice correctPrice =  " + correctPrice + " >>>>>>>>>>>>>>>>");
        return isEmpty(correctPrice, true) ? getPrice(0, formatType) : getPrice(new BigDecimal(0 + correctPrice), formatType);
    }

    /**
     * 获取价格，保留两位小数
     *
     * @param price
     * @return
     */
    public static String getPrice(BigDecimal price) {
        return getPrice(price, PRICE_FORMAT_DEFAULT);
    }

    /**
     * 获取价格，保留两位小数
     *
     * @param price price
     * @return
     */
    public static String getPrice(double price) {
        return getPrice(price, PRICE_FORMAT_DEFAULT);
    }

    /**
     * 获取价格，保留两位小数
     *
     * @param price      price
     * @param formatType 添加单位（元）
     * @return
     */
    public static String getPrice(BigDecimal price, int formatType) {
        return getPrice(price == null ? 0 : price.doubleValue(), formatType);
    }

    /**
     * 获取价格，保留两位小数
     *
     * @param price      price
     * @param formatType 添加单位（元）
     * @return
     */
    public static String getPrice(double price, int formatType) {
        String s = new DecimalFormat("#########0.00").format(price);
        switch (formatType) {
            case PRICE_FORMAT_PREFIX:
                return PRICE_FORMATS[PRICE_FORMAT_PREFIX] + s;
            case PRICE_FORMAT_SUFFIX:
                return s + PRICE_FORMATS[PRICE_FORMAT_SUFFIX];
            case PRICE_FORMAT_PREFIX_WITH_BLANK:
                return PRICE_FORMATS[PRICE_FORMAT_PREFIX_WITH_BLANK] + s;
            case PRICE_FORMAT_SUFFIX_WITH_BLANK:
                return s + PRICE_FORMATS[PRICE_FORMAT_SUFFIX_WITH_BLANK];
            default:
                return s;
        }
    }


    //校正（自动补全等）字符串>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    public static final String SPACE = "\u202F\u202F";

    private static boolean isWhiteSpaces(@Nullable String s) {
        return s != null && s.matches("\\s+");
    }

    public static String toString(@NonNull EditText editText) {
        return editText.getText().toString();
    }

    public static String toString(@NonNull TextView editText) {
        return editText.getText().toString();
    }

    public static String toString(@NonNull TextInputLayout textInputLayout) {
        return textInputLayout.getEditText() != null ? toString(textInputLayout.getEditText()) : "";
    }

    @NonNull
    public static String toNA(@Nullable String value) {
        return isEmpty(value) ? "N/A" : value;
    }

    @NonNull
    public static String toString(@Nullable Object object) {
        return !isEmpty(object) ? object.toString() : "";
    }

    public static long toLong(@NonNull TextView textView) {
        return toLong(toString(textView));
    }

    public static long toLong(@NonNull String text) {
        if (!isEmpty(text)) {
            try {
                return Long.valueOf(text.replace(".", "")
                        .replaceAll(",", "")
                        .replaceAll(" ", ""));
            } catch (NumberFormatException ignored) {
            }
        }
        return 0;
    }


    public static int getSafeIntId(long id) {
        return id > Integer.MAX_VALUE ? (int) (id - Integer.MAX_VALUE) : (int) id;
    }

    public static String capitalizeFirstLetter(String s) {
        if (isEmpty(s)) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }


    //按行写入文件的字符串，格式如下：
    public static String getInputString(long timeStamp, String className, int type, long activeTime) {
        String input = null;
        if (activeTime > 0) {
            input = timeStamp + "  (" + DateUtil.stampToDate(timeStamp) + ")  " + className + "  " + type + "  " + activeTime + "\n";
        } else {
            input = timeStamp + "  (" + DateUtil.stampToDate(timeStamp) + ")  " + className + "  " + type + "\n";
        }

        Log.d("StringUtils", "  input : " + input);
        return input;
    }

    //截取文件名，去除后缀
    public static String getFileNameWithoutSuffix(String fileName) {
        String[] fileNameSplited = fileName.split("\\.");
        if (fileNameSplited.length > 1) {
            Log.d(TAG, "  StringUtils-- : 最新写入的文件  去除后缀  " + fileNameSplited[0]);
            return fileNameSplited[0];
        }
        return "-1";
    }

    //将按行写入文件的字符串，解析出时间戳
    public static long getTimeStampFromString(String record) {
        if (record == null) {
            return 0;
        }
        String[] temp = record.split("  ");
        if (temp.length <= 0) {
            return 0;
        }
        Log.i(TAG, "  StringUtils--getTimeStampFromString : 解析出时间戳  " + temp[0]);
        return Long.parseLong(temp[0]);
    }

    public static String toString(Iterable iterable, String separator) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Object item : iterable) {
            stringBuilder.append(String.valueOf(item));
            stringBuilder.append(separator);
        }

        if (stringBuilder.length() > 2) {
            return stringBuilder.substring(0, stringBuilder.length() - separator.length());
        } else return stringBuilder.toString();
    }

    /**
     * 从 index==start 开始，返回长度不超过 len 的子串
     *
     * @param start 起点
     * @param len   最大长度
     * @return 子串
     */
    public static String subString(String s, int start, int len) {
        if (s == null) return "";
        String title = s;
        title = title.replace("\n", "\\n");
        title = title.substring(start, Math.max(start, Math.min(start + len, title.length() - 1)));
        return title;
    }

    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM-dd");
        }
    };
    private final static ThreadLocal<SimpleDateFormat> dateFormater3 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 时间转换成中文
     *
     * @param time the time
     * @return the string
     */
    public static String friendlyTime(Date time) {

        if (time == null) {
            return "Unknown";
        }
        String ftime = "";
        Calendar cal = Calendar.getInstance();

        // 判断是否是同一天
        String curDate = dateFormater2.get().format(cal.getTime());
        String paramDate = dateFormater2.get().format(time);
        if (curDate.equals(paramDate)) {
            int inter = (int) (cal.getTimeInMillis() - time.getTime()) / 60000;
            int hour = inter / 60;
            if (inter == 0) {
                ftime = "刚刚";
            } else if (hour == 0)
                ftime = Math.max((cal.getTimeInMillis() - time.getTime()) / 60000, 1) + "分钟前";
            else
                ftime = hour + "小时前";
            return ftime;
        }

        long lt = time.getTime() / 86400000;
        long ct = cal.getTimeInMillis() / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max((cal.getTimeInMillis() - time.getTime()) / 60000, 1) + "分钟前";
            else
                ftime = hour + "小时前";
        } else if (days == 1) {
            ftime = "昨天";
        } else if (days == 2) {
            ftime = "前天";
        } else if (days > 2 && days < 31) {
            ftime = days + "天前";
        } else if (days >= 31 && days <= 2 * 31) {
            ftime = "一个月前";
        } else if (days > 2 * 31 && days <= 3 * 31) {
            ftime = "2 个月前";
        } else if (days > 3 * 31 && days <= 4 * 31) {
            ftime = "3 个月前";
        } else if (days < 365) {
            ftime = dateFormater2.get().format(time);
        } else {
            ftime = dateFormater3.get().format(time);
        }
        return ftime;
    }


    /**
     * 时间转换成中文
     *
     * @param time the time
     * @return the string
     */
    public static String friendlyTime(DateTime time) {
        if (time == null) {
            return "Unknown";
        }
        String ftime;
        Calendar cal = Calendar.getInstance();
        // 判断是否是同一天
        long curDate = cal.getTimeInMillis();
        long paramDate = time.getMillis();
        long lt = paramDate / 86400000;
        long ct = curDate / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {
            int hour = (int) ((curDate - paramDate) / 3600000);
            if (hour == 0)
                ftime = Math.max((curDate - paramDate) / 60000, 1) + " 分钟前";
            else
                ftime = hour + " 小时前";
        } else if (days == 1) {
            ftime = "昨天";
        } else if (days == 2) {
            ftime = "前天";
        } else if (days > 2 && days < 31) {
            ftime = days + " 天前";
        } else if (days >= 31 && days <= 2 * 31) {
            ftime = "一个月前";
        } else if (days > 2 * 31 && days <= 3 * 31) {
            ftime = "2 个月前";
        } else if (days > 3 * 31 && days <= 4 * 31) {
            ftime = "3 个月前";
        } else if (days < 365) {
            ftime = time.toString("MM-dd");
        } else {
            ftime = time.toString("yyyy-MM-dd");
        }
        return ftime;
    }

    /**
     * 格式化内存单位
     *
     * @param size 大小
     * @return
     */
    public static String getFormatSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
            return size + "Byte";
        }

        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }


    public static boolean noEmpty(String originStr) {
        return !TextUtils.isEmpty(originStr);
    }


    public static boolean noEmpty(String... originStr) {
        boolean noEmpty = true;
        for (String s : originStr) {
            if (TextUtils.isEmpty(s)) {
                noEmpty = false;
                break;
            }
        }
        return noEmpty;
    }

    /**
     * 从资源文件拿到文字
     */
    public static String getResourceString(int strId) {
        String result = "";
        if (strId > 0) {
            result = BaseApplication.getContext().getResources().getString(strId);
        }
        return result;
    }

    /**
     * 从资源文件得到文字并format
     */
    public static String getResourceStringAndFormat(int strId, Object... objs) {
        String result = "";
        if (strId > 0) {
            result = String.format(Locale.getDefault(), BaseApplication.getContext().getResources().getString(strId), objs);
        }
        return result;
    }
}