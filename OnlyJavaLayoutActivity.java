package com.soft.li.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class OnlyJavaLayoutActivity extends Activity {
    private boolean clicked = false;
    private Button myButton;
    private EditText myEditText;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //定义两个控件，button和edittext
        myButton = new Button(this);
        myButton.setText("Press me");

        myEditText = new EditText(this);
        myEditText.setHint("See me");

        //为空间设置ID
        myButton.setId(1);
        myEditText.setId(2);

        //定义好父容器并设置相关属性
        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.BLUE);

        //设置Button的布局参数
        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

        //设置EditText的布局参数
        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textParams.addRule(RelativeLayout.ABOVE, myButton.getId());
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.setMargins(0, 0, 0, 80);//这里的80是px

        //设置EditText的宽度为指定大小宽度,要相应的dp转化为px
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());

        myEditText.setWidth(px);
        //将布局添加到父容器中
        myLayout.addView(myButton, buttonParams);
        myLayout.addView(myEditText, textParams);

        //设置显示父容器
        setContentView(myLayout);

        //为Button设置点击事件，点击使其变宽
        final int wrapWidth = myButton.getLayoutParams().width;
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击Button之后使其宽度变宽，再次点击恢复之前的wrap_content状态，可以配合属性动画使其变化更加自然
                if (!clicked) {
                    myButton.getLayoutParams().width = 800;
                } else {
                    myButton.getLayoutParams().width = wrapWidth;
                }
                clicked = !clicked;
                myButton.requestLayout();
            }
        });
    }
}

/*作者：Turwe
        链接：https://www.jianshu.com/p/7aedea560f16
        來源：简书
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
