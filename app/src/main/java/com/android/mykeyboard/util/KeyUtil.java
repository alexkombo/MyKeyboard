package com.android.mykeyboard.util;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputConnection;

import com.android.mykeyboard.R;

/**
 * Created by kombo on 28/02/2019.
 */
public class KeyUtil {

    public static void performButtonClick(View view,  InputConnection inputConnection, SparseArray<String> keyValues){
        if (inputConnection == null) {
            Log.e("IC", "connection is null");
            return;

        }
        //we're only handling backspace, shift, caps and other buttons can also be handled here
        if (view.getId() == R.id.key_backspace) {
            deleteText(inputConnection);
        } else {
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value, 1);
        }
    }

    public static void deleteText(InputConnection inputConnection){
        CharSequence selectedText = inputConnection.getSelectedText(0);

        //if no selection, delete the previous character, otherwise, delete selected text
        if (TextUtils.isEmpty(selectedText)) {
            inputConnection.deleteSurroundingText(1, 0);
        } else {
            inputConnection.commitText("", 1);
        }
    }

    public static void populateNumberedKeyboard(SparseArray<String> keyValues) {
        keyValues.put(R.id.key_0, "0");
        keyValues.put(R.id.key_1, "1");
        keyValues.put(R.id.key_2, "2");
        keyValues.put(R.id.key_3, "3");
        keyValues.put(R.id.key_4, "4");
        keyValues.put(R.id.key_5, "5");
        keyValues.put(R.id.key_6, "6");
        keyValues.put(R.id.key_7, "7");
        keyValues.put(R.id.key_8, "8");
        keyValues.put(R.id.key_9, "9");

        populateNumberlessKeyboard(keyValues);
    }

    public static void populateNumberlessKeyboard(SparseArray<String> keyValues){
        keyValues.put(R.id.key_q, "q");
        keyValues.put(R.id.key_w, "w");
        keyValues.put(R.id.key_e, "e");
        keyValues.put(R.id.key_r, "r");
        keyValues.put(R.id.key_t, "t");
        keyValues.put(R.id.key_y, "y");
        keyValues.put(R.id.key_u, "u");
        keyValues.put(R.id.key_i, "i");
        keyValues.put(R.id.key_o, "o");
        keyValues.put(R.id.key_p, "p");
        keyValues.put(R.id.key_a, "a");
        keyValues.put(R.id.key_s, "s");
        keyValues.put(R.id.key_d, "d");
        keyValues.put(R.id.key_f, "f");
        keyValues.put(R.id.key_g, "g");
        keyValues.put(R.id.key_h, "h");
        keyValues.put(R.id.key_j, "j");
        keyValues.put(R.id.key_k, "k");
        keyValues.put(R.id.key_l, "l");
        keyValues.put(R.id.key_z, "z");
        keyValues.put(R.id.key_x, "x");
        keyValues.put(R.id.key_c, "c");
        keyValues.put(R.id.key_v, "v");
        keyValues.put(R.id.key_b, "b");
        keyValues.put(R.id.key_n, "n");
        keyValues.put(R.id.key_m, "m");
        keyValues.put(R.id.key_space, " ");
    }
}
