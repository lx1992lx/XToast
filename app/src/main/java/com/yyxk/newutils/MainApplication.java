package com.yyxk.newutils;

import android.app.Application;

import com.yyxk.x_toast.XToast;
import com.yyxk.x_toast.XToastConfig;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * 项目名称：NewUtils
 * 包名:com.yyxk.newutils
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/11 上午10:32
 * 修改人：LX
 * 修改时间：2018/2/11 上午10:32
 * 修改备注：
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XToast.init(this);//初始化Toast
        XToastConfig config=new XToastConfig();
        config.setAnimation(R.style.CustomToastAnim)            //设置动画
                .setBufferSize(3)                               //设置缓存Toast数量，这个参数有利于当Toast数量过多时，可以省略过多的Toast
                .setDefaultLayout(R.layout.default_toast_layout)//设置Toast布局
                .setDirection(XToastConfig.DIRECTION.BOTTOM)    //设置方向，上/下
                .setHeight(50)                                  //设置高度
                .setWidth(300)                                  //设置宽度
                .setMarginHorizontal(10)                        //设置水平Margin
                .setMarginVertical(10)                          //设置垂直Margin
                .setTimeLong(2500);                             //设置弹出时长
    }
}
