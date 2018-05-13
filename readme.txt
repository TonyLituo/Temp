第一个参数是组件，第二个参数是动画操作方式，有以下几种：


平移 translationX，translationY，X，Y

旋转 rotation，rotationX，rotationY

透明度 alpha

缩放 scaleX，scaleY

也可这样写

ObjectAnimator animation = ObjectAnimator.ofFloat(image, "rotationY", 0,360).setDuration(500);
animation.setRepeatCount(4);
animation.start();

作者：八月之雨
链接：https://www.jianshu.com/p/a69f951d2fa9
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。