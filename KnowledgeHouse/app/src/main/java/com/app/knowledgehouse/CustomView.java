package com.app.knowledgehouse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.GenericArrayType;

public class CustomView extends androidx.appcompat.widget.AppCompatTextView {

    private String[] fruits = {"Apple","Orange","Banana","Guava","Cherry"};

    public CustomView(@NonNull Context context) {
        super(context);
        setUpSize();
        clickListener();
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpSize();
        clickListener();
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void setUpSize(){
        setTextSize(TypedValue.COMPLEX_UNIT_SP,22);
        setGravity(Gravity.CENTER);
        setTextColor(Color.GREEN);
    }
    private void clickListener(){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(generateRandomWord());
            }
        });
        setText(generateRandomWord());
    }
    private String generateRandomWord(){
        int index = (int) (Math.random()*fruits.length);
        return fruits[index];
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP){
            setText(generateRandomWord());
            return true;
        }
        return false;
    }
}
