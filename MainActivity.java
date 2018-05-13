package com.soft.li.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button mButton;
ImageView mImageView;
ObjectAnimator mAnimator;
ObjectAnimator mAnimator1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=findViewById(R.id.start);
        mImageView=findViewById(R.id.pic);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }

    private void show(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int right=dm.widthPixels;
        int bottom=dm.heightPixels;
        int x=mImageView.getWidth();
        int y=mImageView.getHeight();
        mImageView.setPivotX(x);
        mImageView.setPivotY(y);
//
//        Rect startbound=new Rect(0,0,right/2,bottom/2);
        mAnimator =ObjectAnimator.ofFloat(mImageView,"scaleX",1,0.2f);
        mAnimator1 =ObjectAnimator.ofFloat(mImageView,"scaleY",1,0.2f);
        AnimatorSet set=new AnimatorSet();
        set.playTogether(mAnimator,mAnimator1);
        set.setDuration(3000);

//        mAnimator1 =ObjectAnimator.ofFloat(mImageView,"scaleX",1,0.2f);

set.start();
    }
}
