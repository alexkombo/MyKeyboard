package com.android.mykeyboard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.mykeyboard.R;
import com.android.mykeyboard.R2;
import com.android.mykeyboard.util.KeyUtil;
import com.android.mykeyboard.util.PrefUtils;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by kombo on 28/02/2019.
 */
public class AlphanumericKeyboard extends LinearLayout {

    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;

    @BindView(R2.id.key_backspace)
    Button backspace;
    @BindView(R2.id.key_space)
    Button space;

    @OnClick({
            R2.id.key_0, R2.id.key_a, R2.id.key_1, R2.id.key_2, R2.id.key_3, R2.id.key_4, R2.id.key_5, R2.id.key_6, R2.id.key_7, R2.id.key_8, R2.id.key_9,
            R2.id.key_b, R2.id.key_c, R2.id.key_d, R2.id.key_e, R2.id.key_f, R2.id.key_g, R2.id.key_h, R2.id.key_i, R2.id.key_j, R2.id.key_k,
            R2.id.key_l, R2.id.key_m, R2.id.key_n, R2.id.key_o, R2.id.key_p, R2.id.key_q, R2.id.key_r, R2.id.key_s, R2.id.key_t, R2.id.key_u, R2.id.key_v,
            R2.id.key_w, R2.id.key_x, R2.id.key_y, R2.id.key_z, R2.id.key_space, R2.id.key_backspace
    })
    public void onButtonClick(View view) {
        KeyUtil.performButtonClick(view, inputConnection, keyValues);
    }

    @OnLongClick(R2.id.key_backspace)
    public void onButtonLongClick() {
        if (inputConnection != null)
            deleteText(inputConnection);
    }

    public AlphanumericKeyboard(Context context) {
        this(context, null, 0);
    }

    public AlphanumericKeyboard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AlphanumericKeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attributeSet) {
        if (PrefUtils.getTheme(context, PrefUtils.PLAIN).equals(PrefUtils.PLAIN))
            LayoutInflater.from(context).inflate(R.layout.numbered_keyboard_view, this, true);
        else
            LayoutInflater.from(context).inflate(R.layout.numbered_keyboard_blue, this, true);

        ButterKnife.bind(this);

        space.setHeight(backspace.getMeasuredHeight());

        KeyUtil.populateNumberedKeyboard(keyValues);
    }

    public void setInputConnection(InputConnection inputConnection) {
        this.inputConnection = inputConnection;
    }

    private void deleteText(InputConnection inputConnection) {
        KeyUtil.deleteText(inputConnection);
    }
}
