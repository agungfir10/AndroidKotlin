package com.agungfir.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.agungfir.android.R;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public static class Properties {
        public int myAttr;
    }

    public static Properties getProperties(@NonNull Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        Properties properties = new Properties();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView, defStyleAttr, defStyleRes);

        properties.myAttr = typedArray.getInt(R.styleable.MyView_myAttr, 0);
        typedArray.recycle();
        return properties;
    }
}
