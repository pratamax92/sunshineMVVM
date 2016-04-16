package com.example.android.sunshine.utils;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by ibun on 06/01/16.
 */
public abstract class MyTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public abstract void afterTextChanged(Editable s);
}
