package com.example.propertyanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.Button;

import android.view.View;

import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.AccelerateInterpolator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.TimeAnimator;

public class MainActivity extends AppCompatActivity {

    private Button ObjectAnimatorBtn,ValueAnimatorBtn;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.image);
        ObjectAnimatorBtn = (Button) findViewById(R.id.ObjectAnimatorBtn);
        ValueAnimatorBtn = (Button) findViewById(R.id.ValueAnimatorBtn);

        ValueAnimatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f,0f);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        view.setAlpha((float) animation.getAnimatedValue());
                    }
                });
                valueAnimator.setDuration(1000);
                valueAnimator.start();
            }
        });
    }

    public void startAnimation(View v) {
        switch (v.getId()) {
            case R.id.ObjectAnimatorBtn:
                ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
                animator.setDuration(1000);//时间1s
                animator.start();
                break;
            default:
                break;
        }
    }
}
