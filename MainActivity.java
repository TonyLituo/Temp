package com.soft.li.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
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
EditView mEditView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = this.findViewById(R.id.start);
        mImageView = this.findViewById(R.id.pic);
        mEditView=this.findViewById(R.id.cv);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,OnlyJavaLayoutActivity.class);
                startActivity(intent);
            }
        });
//        new Thread(mEditView).start();
    }

    private void show() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int right = dm.widthPixels;
        int bottom = dm.heightPixels;
        int x = mImageView.getWidth();
        int y = mImageView.getHeight();
        mImageView.setPivotX(x);
        mImageView.setPivotY(y);
//
//        Rect startbound=new Rect(0,0,right/2,bottom/2);
        mAnimator = ObjectAnimator.ofFloat(mImageView, "scaleX", 1, 0.2f);
        mAnimator1 = ObjectAnimator.ofFloat(mImageView, "scaleY", 1, 0.2f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(mAnimator, mAnimator1);
        set.setDuration(3000);

//        mAnimator1 =ObjectAnimator.ofFloat(mImageView,"scaleX",1,0.2f);

        set.start();
    }

    private void showValueAnmi() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                mButton.setText(value + "");
            }
        });
        valueAnimator.start();
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                show();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });
    }

}
