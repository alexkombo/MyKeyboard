package com.android.mykeyboard.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by kombo on 01/03/2019.
 */
public class PrefUtils {

    public static String PLAIN = "plain";
    public static String BLUE = "blue";

    public static String getTheme(Context context, String defValue) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getString("Theme", defValue);
    }

    public static void putTheme(Context context, String value){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor  editor = settings.edit();
        editor.putString("Theme", value);
        editor.apply();
    }
}
