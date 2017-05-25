package com.example.animationdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

public class MyView extends View {
	private boolean flag = false;
	private int transLastX = 20;
	private int transLastY = 30;
	private int lastX = 0;
	private int lastY = 0;
	private AnimationDrawable frameAnimation;
	private TranslateAnimation tAnimation;
	Bitmap bmp;
	Paint paint;
	
	Bitmap bmps[] = new Bitmap[5];
    int currentFrame;
    
	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		for(int i = 0; i < bmps.length; i ++ ){
			bmps[i] = BitmapFactory.decodeResource(this.getResources(), R.drawable.boy1+i);
		}
		bmp = BitmapFactory
				.decodeResource(this.getResources(), R.drawable.boy1);
		paint = new Paint();
        
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawBitmap(bmp, transLastX, transLastY, paint);
		canvas.drawBitmap(bmps[currentFrame], transLastX,transLastY*3, paint);
		super.onDraw(canvas);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		final int x = (int) event.getX();
		final int y = (int) event.getY();
		tAnimation = new TranslateAnimation(lastX, x-transLastX, lastY, y-transLastY);
        tAnimation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				flag = true;
				logic();
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				lastX = x - transLastX;
				lastY = y - transLastY;
				flag = false;
				invalidate();
			}
		});
		tAnimation.setFillAfter(true);
		tAnimation.setDuration(2000);
        this.startAnimation(tAnimation);
        
		return true;
	}
     
	void logic(){
		currentFrame ++;
		if(currentFrame >= bmps.length){
			currentFrame = 0;
		}
	}
//	@Override
//	public void run(){
//		while(flag){
//			long start = System.currentTimeMillis();
//			logic();
//			invalidate();
//			long end = System.currentTimeMillis();
//			try{
//				if(end-start < 50){
//					Thread.sleep(50-(end-start));
//				}
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
//		}
//	}
}
