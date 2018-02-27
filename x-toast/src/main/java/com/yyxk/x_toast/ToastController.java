package com.yyxk.x_toast;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
 * 创建时间：2018/1/29 下午5:17
 * 修改人：LX
 * 修改时间：2018/1/29 下午5:17
 * 修改备注：
 */

public class ToastController {
    private static ToastController mController;
    private static final int TOAST_SHOW = 0, TOAST_HIDE = 1;
    private List<ToastEntry> mReadyToShowList = new ArrayList<>();//准备显示Toast View的列表
    private static boolean isShowing = false;//是否正在显示Toast
    private WindowManager mManager;

    public enum TOAST_TYPE {
        NORMAL,
        CUSTOM
    }//Normal类型Toast使用的是defaultLayout，可以自定义DefaultLayout但是必须指定一个id为ToastText的TextView


    private ToastController() {
    }

    public static ToastController getInstance() {
        if (mController == null)
            mController = new ToastController();

        return mController;
    }

    protected static XToastConfig createDefaultConfig() {
        XToastConfig defaultConfig = new XToastConfig();
        defaultConfig.setDirection(XToastConfig.DIRECTION.BOTTOM)
                .setDefaultLayout(R.layout.default_toast_layout)
                .setMarginVertical(50)
                .setBufferSize(3)
                .setAnimation(R.style.DefaultToastAnimation)
                .setTimeLong(3000);

        return defaultConfig;
    }

    /**
     * 显示Toast
     *
     * @param config
     * @param type
     * @param text
     * @param view
     */
    public void show(Context context, XToastConfig config, TOAST_TYPE type, @Nullable String text, @Nullable View view) {
        View layout;

        if (type == TOAST_TYPE.NORMAL) {
            if (config.getDefaultLayout() != 0) {
                layout = LayoutInflater.from(context).inflate(config.getDefaultLayout(), null);
            }else{
                layout= LayoutInflater.from(context).inflate(R.layout.default_toast_layout,null);
            }
            TextView textView = layout.findViewById(R.id.toast_text);
            if (textView == null) {
                throw new IllegalArgumentException("defaultLayout必须包含一个id为toast_text的TextView");
            }
            textView.setText(text);
        } else {
            layout = view;
        }

        DisplayMetrics dm = new DisplayMetrics();
        if (mManager == null)
            mManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int flag = config.isTouchable() ? WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON : WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        params.flags = flag;
        params.type = WindowManager.LayoutParams.TYPE_TOAST;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.format = PixelFormat.TRANSLUCENT;
        params.gravity = config.getDirection() == XToastConfig.DIRECTION.TOP ? Gravity.TOP : config.getDirection() == XToastConfig.DIRECTION.BOTTOM?Gravity.BOTTOM:Gravity.CENTER ;
        params.horizontalMargin = FontDisplayUtil.dip2px(context, config.getMarginHorizontal()) / (float) FontDisplayUtil.getScreenWidth(context);
        params.verticalMargin = FontDisplayUtil.dip2px(context, config.getMarginVertical()) / (float) FontDisplayUtil.getScreenHeight(context);
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN;
        if (config.getAnimation() != 0)
            params.windowAnimations = config.getAnimation();
        if (config.getWidth() != 0)
            params.width = config.getWidth();
        if (config.getHeight() != 0)
            params.height = config.getHeight();

        ToastEntry entry = new ToastEntry();
        entry.setView(layout)
                .setBufferSize(config.getBufferSize())
                .setTimeLong(config.getTimeLong())
                .setParams(params);
        mReadyToShowList.add(entry);

        mHandler.sendEmptyMessage(TOAST_SHOW);
    }


    /**
     * handler处理Toast的显示和隐藏
     */
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TOAST_SHOW:
                    if (!isShowing && mReadyToShowList.size() > 0) {
                        //如果Toast同时显示数量大于预设量，移除最先进入的View
                        removeNotUsedToast(mReadyToShowList.get(0).getBufferSize());
                        WindowManager.LayoutParams params = mReadyToShowList.get(0).getParams();
                        mManager.addView(mReadyToShowList.get(0).getView(), params);
                        startCount(mReadyToShowList.get(0).getTimeLong());
                        isShowing = true;
                    }
                    break;
                case TOAST_HIDE:
                    isShowing = false;
                    mManager.removeView(mReadyToShowList.get(0).getView());
                    mReadyToShowList.remove(0);
                    if (mReadyToShowList.size() > 0)
                        mHandler.sendEmptyMessage(TOAST_SHOW);
                    break;
            }
        }
    };

    /**
     * 开始计时
     *
     * @param time 总时长
     */
    private void startCount(int time) {
        CountDownTimer timer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                mHandler.sendEmptyMessage(TOAST_HIDE);
            }
        };
        timer.start();
    }

    /**
     * 移除多余Toast
     */
    private void removeNotUsedToast(int maxSize) {
        while (maxSize >= 1 && mReadyToShowList.size() > maxSize) {
            mReadyToShowList.remove(0);
        }
    }

    public void hideAll(){
        isShowing = false;
        mManager.removeView(mReadyToShowList.get(0).getView());
        mReadyToShowList.clear();
    }

}
