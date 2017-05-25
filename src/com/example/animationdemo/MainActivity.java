package com.example.animationdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView image;
	private AnimationDrawable frameAnimation;
	private TranslateAnimation translateAnimation;
	private AnimationSet animationSet;
	private int transLastX = 0;
	private int transLastY = 0;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new MyView(this));
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.boy_img);
        image.setBackgroundResource(R.anim.anim);   
        frameAnimation=(AnimationDrawable) image.getBackground();
        View layout = findViewById(R.id.limg);
        
        
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x=event.getX();
                float y=event.getY();
                final TranslateAnimation animation1=new TranslateAnimation(transLastX,x,transLastY,y);
                animation1.setDuration(3000);
                animation1.setFillAfter(false);
                if (frameAnimation.isRunning()) //如果正在播放,则先停止
                    frameAnimation.stop();
                frameAnimation.start();
                // imageView.setAnimation(animation);
                image.startAnimation(animation1);
                return false;
            }
        });
        
        //
//        int x = 100;
//        int y = 200;
//        translateAnimation = new TranslateAnimation(transLastX, x, transLastY, y);
//        translateAnimation.setDuration(1000);
//        translateAnimation.setFillAfter(true);
//        transLastX = x;
//        transLastY = y;
//        image.startAnimation(translateAnimation);
//        view.setOnTouchListener(new OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				// TODO Auto-generated method stub
//				int x = (int) event.getX();
//				int y = (int) event.getY();
//				translateAnimation = new TranslateAnimation(transLastX, x, transLastY, y);
//		        translateAnimation.setDuration(1000);
//		        translateAnimation.setFillAfter(true);
//		        transLastX = x;
//		        transLastY = y;
//		        image.startAnimation(translateAnimation);
//				return true;
//			}
//		});
    }
}
