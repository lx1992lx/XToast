package com.yyxk.x_toast;

import android.app.Application;
import android.content.Context;
import android.view.View;

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
 * 项目名称：ArchFrameworkTest
 * 包名:com.yyxk.systemdialog
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/1/29 下午4:21
 * 修改人：LX
 * 修改时间：2018/1/29 下午4:21
 * 修改备注：
 */

public class XToast  {

    private static XToastConfig mConfig;
    private static Context mContext;


    public static XToastConfig init(Application application) {
        if (mConfig == null)
            mConfig = ToastController.getInstance().createDefaultConfig();
        mContext=application.getApplicationContext();
        return mConfig;
    }

    public static void showText(String text) {
        ToastController.getInstance().show(mContext,mConfig, ToastController.TOAST_TYPE.NORMAL,text,null);
    }

    public static void showView(View view) {
        ToastController.getInstance().show(mContext,mConfig, ToastController.TOAST_TYPE.CUSTOM,null,view);
    }

    public static void showText(String text, XToastConfig config) {
        ToastController.getInstance().show(mContext,config, ToastController.TOAST_TYPE.NORMAL,text,null);
    }

    public static void showView(View view, XToastConfig config) {
        ToastController.getInstance().show(mContext,config, ToastController.TOAST_TYPE.CUSTOM,null,view);
    }

    public static void hideAll(){
        ToastController.getInstance().hideAll();
    }

}
