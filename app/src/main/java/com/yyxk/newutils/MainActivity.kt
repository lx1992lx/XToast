package com.yyxk.newutils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import com.yyxk.x_toast.FontDisplayUtil
import com.yyxk.x_toast.XToast
import com.yyxk.x_toast.XToastConfig
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener {
            showNormalToast()
        }
        btn2.setOnClickListener {
            showCustomToast()
        }
        btn3.setOnClickListener {
            showCustomViewToast()
        }

    }

    private fun showCustomViewToast() {
        var config=XToastConfig()
        config.setAnimation(R.style.CustomToastAnim)
                .setBufferSize(3)
                .setDirection(XToastConfig.DIRECTION.TOP)
                .setMarginVertical(0)
                .setTimeLong(3000)
                .width = FontDisplayUtil.getScreenWidth(this)
        var view=LayoutInflater.from(this).inflate(R.layout.custom_toast,null)
        XToast.showView(view,config)
    }

    private fun showCustomToast() {
        var config=XToastConfig()
        config.setAnimation(R.style.CustomToastAnim)
                .setBufferSize(3)
                .setDirection(XToastConfig.DIRECTION.TOP)
                .setMarginVertical(0)
                .setTimeLong(3000)
                .width=FontDisplayUtil.getScreenWidth(this)

        XToast.showText("这是自定义动画的Toast",config)
    }

    private fun showNormalToast() {
        XToast.showText("这是正常的Toast")
    }




}
