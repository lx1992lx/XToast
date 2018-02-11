package com.yyxk.newutils;

import android.app.Application;

import com.yyxk.x_toast.XToast;

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
    }
}
