package com.example.tweenanimation;

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

import com.example.tweenanimation.Rotate3dAnimation;

public class MainActivity extends AppCompatActivity {

    private Button startAnimationBtn,translateAnimationBtn,groupAnimationBtn;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.image);
        startAnimationBtn = (Button) findViewById(R.id.startAnimationBtn);
        translateAnimationBtn = (Button) findViewById(R.id.translateAnimationBtn);
        groupAnimationBtn = (Button) findViewById(R.id.groupAnimationBtn);
    }

    public void startTweenAnimation(View v) {
        switch (v.getId()) {
            case R.id.startAnimationBtn:
                final float centerX = view.getWidth() / 2.0f;
                final float centerY = view.getHeight() / 2.0f;
                final Rotate3dAnimation rotation = new Rotate3dAnimation(0, 180, centerX, centerY, 1.0f, true);
                rotation.setDuration(1500);
                rotation.setFillAfter(true);
                rotation.setInterpolator(new AccelerateInterpolator());
                view.startAnimation(rotation);
                break;
            case R.id.translateAnimationBtn:
                Animation translateAnimation = new TranslateAnimation(0,500,0,0);
                translateAnimation.setDuration(2000);
                translateAnimation.setFillAfter(true);
                view.startAnimation(translateAnimation);
                break;
            case R.id.groupAnimationBtn:
                AnimationSet setAnimation = new AnimationSet(true);
                setAnimation.setRepeatMode(Animation.RESTART);
                setAnimation.setRepeatCount(1);
                //子动画1
                Animation translateAnimation1 = new TranslateAnimation(0,500,0,0);
                translateAnimation1.setDuration(2000);
                translateAnimation1.setFillAfter(true);
                //子动画2
                Animation alphaAnimation1 = new AlphaAnimation(1,0);
                alphaAnimation1.setDuration(2000);
                //组合
                setAnimation.addAnimation(translateAnimation1);
                setAnimation.addAnimation(alphaAnimation1);
                view.startAnimation(setAnimation);
                break;
            default:
                break;
        }
    }
}
