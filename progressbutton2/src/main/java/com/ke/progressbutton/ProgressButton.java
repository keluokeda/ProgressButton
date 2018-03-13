package com.ke.progressbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;


public class ProgressButton extends FrameLayout {
    private Button mButton;
    private ProgressBar mProgressBar;


    public ProgressButton(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public ProgressButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ProgressButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }


    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int defStyleAttr) {

        if (attributeSet == null) {
            return;
        }
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressButton);

        Drawable buttonDrawable = typedArray.getDrawable(R.styleable.ProgressButton_btn_bg);
        String text = typedArray.getString(R.styleable.ProgressButton_btn_text);

        int textColor = typedArray.getColor(R.styleable.ProgressButton_btn_text_color, Color.BLACK);
        float textSize = typedArray.getFloat(R.styleable.ProgressButton_btn_text_size, 14);


        mButton = new Button(context);
        addView(mButton, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if (buttonDrawable != null) {
            mButton.setBackground(buttonDrawable);
        }
        mButton.setText(text);
        mButton.setTextColor(textColor);
        mButton.setTextSize(textSize);


        mProgressBar = new ProgressBar(context, attributeSet, defStyleAttr);
        mProgressBar.setIndeterminate(true);
        mProgressBar.setVisibility(INVISIBLE);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        addView(mProgressBar, layoutParams);

        typedArray.recycle();
    }

    @Override
    public void setEnabled(boolean enabled) {
//        super.setEnabled(enabled);
        mButton.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
//        return super.isEnabled();
        return mButton.isEnabled();
    }

    public void setProgressShow(boolean isShow) {
        if (isShow) {
            mButton.setVisibility(INVISIBLE);
            mProgressBar.setVisibility(VISIBLE);
        } else {
            mButton.setVisibility(VISIBLE);
            mProgressBar.setVisibility(INVISIBLE);
        }
    }

    public boolean isShowingProgress() {
        return mProgressBar.getVisibility() == VISIBLE;
    }


    @Override
    public void setOnClickListener(final @Nullable OnClickListener l) {
//        super.setOnClickListener(l);
//        mButton.setOnClickListener(l);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                l.onClick(ProgressButton.this);
                if (l != null) {
                    l.onClick(ProgressButton.this);
                }
            }
        });
        mButton.setId(getId());
    }
}
