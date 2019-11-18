package com.example.frameanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;

import android.view.View;

import android.widget.ImageView;

import 	android.graphics.drawable.AnimationDrawable;

import android.graphics.drawable.Drawable;

public class MainActivity extends AppCompatActivity {

    private Button startAnimationBtn,codeAnimationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView(){
        startAnimationBtn = (Button) findViewById(R.id.startAnimationBtn);
        codeAnimationBtn = (Button) findViewById(R.id.codeAnimationBtn);
    }

    public void startFrameAnimation(View v) {
        switch (v.getId()) {
            case R.id.startAnimationBtn:
                ImageView image = (ImageView) findViewById(R.id.image);
                AnimationDrawable animationDrawable = (AnimationDrawable) image.getDrawable();
                animationDrawable.stop();
                animationDrawable.selectDrawable(0);
                animationDrawable.start();
                break;
            case R.id.codeAnimationBtn:
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                ImageView image2 = (ImageView) findViewById(R.id.image2);
                int id = 0;
                for (int i = 0; i < 60; i++) {
                    id = getResources().getIdentifier("p" + i, "mipmap", getPackageName());
                    Drawable drawable = getResources().getDrawable(id);
                    animationDrawable2.addFrame(drawable, 100);
                }
                image2.setImageDrawable(animationDrawable2);
                animationDrawable2.setOneShot(false);
                animationDrawable2.start();
                break;

            default:
                break;
        }
    }
}
