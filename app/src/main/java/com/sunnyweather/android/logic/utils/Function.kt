package com.sunnyweather.android.logic.utils

import android.content.Context
import android.content.SharedPreferences
import android.view.Window
import android.view.WindowManager

@Suppress("unused")
object Function {

    fun hideStatusBar(window: Window) {
        val attrs: WindowManager.LayoutParams = window.attributes
        attrs.flags = attrs.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
        window.attributes = attrs
    }

    fun showStatusBar(window: Window) {
        val attrs: WindowManager.LayoutParams = window.attributes
        attrs.flags = attrs.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
        window.attributes = attrs
    }

    /**
     * 判断是否是第一次启动程序 利用 SharedPreferences 将数据保存在本地
     * */
    fun isFirstRun(context: Context): Boolean {
        val sp = context.getSharedPreferences("isFirstRun", Context.MODE_PRIVATE)
        val isFirstRun = sp.getBoolean("isFirstRun", true)
        val editor = sp.edit()
        return if (isFirstRun) {
            editor.putBoolean("isFirstRun", false)
            editor.apply()
            true
        } else {
            false
        }
    }



}