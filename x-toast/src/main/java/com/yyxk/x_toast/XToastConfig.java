package com.yyxk.x_toast;

import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;

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
 * 创建时间：2018/1/29 下午4:24
 * 修改人：LX
 * 修改时间：2018/1/29 下午4:24
 * 修改备注：
 */

public class XToastConfig {
    private @LayoutRes int defaultLayout;
    private int marginVertical;
    private int marginHorizontal;
    private DIRECTION mDirection;
    private int timeLong;
    private @StyleRes int animation;
    private int bufferSize=3;
    private int width;//可以为0，代表WrapContent
    private int height;//可以为0，代表WrapContent
    private boolean touchable;

    public enum DIRECTION{
        TOP,
        BOTTOM,
        CENTER
    }

    public int getDefaultLayout() {
        return defaultLayout;
    }

    public XToastConfig setDefaultLayout(@LayoutRes int defaultLayout) {
        this.defaultLayout = defaultLayout;
        return this;
    }

    public int getMarginVertical() {
        return marginVertical;
    }

    public XToastConfig setMarginVertical(int marginVertical) {
        this.marginVertical = marginVertical;
        return this;
    }

    public int getMarginHorizontal() {
        return marginHorizontal;
    }

    public XToastConfig setMarginHorizontal(int marginHorizontal) {
        this.marginHorizontal = marginHorizontal;
        return this;
    }

    public DIRECTION getDirection() {
        return mDirection;
    }

    public XToastConfig setDirection(DIRECTION direction) {
        mDirection = direction;
        return this;
    }

    public int getTimeLong() {
        return timeLong;
    }

    public XToastConfig setTimeLong(int timeLong) {
        this.timeLong = timeLong;
        return this;
    }

    public int getAnimation() {
        return animation;
    }

    public XToastConfig setAnimation(@StyleRes int animation) {
        this.animation = animation;
        return this;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public XToastConfig setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
        return this;
    }

    public boolean isTouchable() {
        return touchable;
    }

    public XToastConfig setTouchable(boolean touchable) {
        this.touchable = touchable;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public XToastConfig setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public XToastConfig setHeight(int height) {
        this.height = height;
        return this;
    }
}

