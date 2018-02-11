package com.yyxk.x_toast;

import android.view.View;
import android.view.WindowManager;

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
 * 创建时间：2018/1/30 下午4:38
 * 修改人：LX
 * 修改时间：2018/1/30 下午4:38
 * 修改备注：
 */

public class ToastEntry {
    private View view;
    private int timeLong;
    private int bufferSize;
    private WindowManager.LayoutParams params;

    public View getView() {
        return view;
    }

    public ToastEntry setView(View view) {
        this.view = view;
        return this;
    }

    public int getTimeLong() {
        return timeLong;
    }

    public ToastEntry setTimeLong(int timeLong) {
        this.timeLong = timeLong;
        return this;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public ToastEntry setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
        return this;
    }

    public WindowManager.LayoutParams getParams() {
        return params;
    }

    public ToastEntry setParams(WindowManager.LayoutParams params) {
        this.params = params;
        return this;
    }
}
