# XToast,一个方便自定义的Toast工具
---------------
![image](https://github.com/lx1992lx/XToast/blob/master/kkk.gif)

<br><br>
XToast可以方便的自定义Toast的布局、动画、弹出位置等，方便再次封装。
---------
<br>
使用方法：
---------
<br>
 1.集成XToast：

    compile 'com.yyxk.XToast:x-toast:1.0.1'
    
 <br>
 2. 在Application的onCreate()方法中初始化XToast：

    
          XToast.init(this);

<br>
 3.使用默认方案的XToast：


          XToast.showText("这是正常的Toast")；
<br>
 4.使用自定义配置XToastConfig来配置XToast：
    
           XToastConfig config=new XToastConfig();
            config.setAnimation(R.style.CustomToastAnim)            //设置动画
                    .setBufferSize(3)                               //设置缓存Toast数量，
                                                                    //这个参数有利于当Toast数量过多时，可以省略过多的Toast
                    .setDirection(XToastConfig.DIRECTION.BOTTOM)    //设置方向，上/下
                    .setDefaultLayout(R.layout.default_toast_layout)//设置Toast布局(这个布局必须包含一个id为toast_text的TextView)
                    .setHeight(50)                                  //设置高度
                    .setWidth(300)                                  //设置宽度
                    .setMarginHorizontal(10)                        //设置水平Margin
                    .setMarginVertical(10)                          //设置垂直Margin
                    .setTimeLong(2500);                             //设置弹出时长
           XToast.showText("这是自定义参数的Toast",config);
<br>
 5.使用自定义View,同showText()：
        
            XToast.showView(View view,Concig config)
            XToast.showView(View view,Config config)

