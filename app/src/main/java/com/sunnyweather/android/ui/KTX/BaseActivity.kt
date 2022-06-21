package com.sunnyweather.android.ui.KTX

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

abstract class BaseActivity<ActBinding: ViewDataBinding>: AppCompatActivity {

    constructor(): super()

    constructor(@LayoutRes layout: Int) : super(layout)

    //protected子类可以抽取对象 private不行
    protected lateinit var mBinding: ActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = bindView(getLayoutRes())
        initView()
        initConfig()
        initData()
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    //初始化视图
    open fun initView() { }

    //open才能被子类重写 默认fun不能被重写和继承
    //初始化配置
    open fun initConfig() { }

    //初始化数据
    open fun initData() { }

    override fun onDestroy() {
        super.onDestroy()
        //用lateinit初始化的字段最好要做判断有没有成功
        if (this::mBinding.isInitialized){
            mBinding.unbind()
        }
    }


    /**
     * 沉浸式状态栏
     */
    protected open fun immersionStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            // 沉浸式状态栏
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            // 状态栏改为透明
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    /*
    * 扩展liveData的observer函数
    * */
    protected inline fun <T: Any?> LiveData<T>.observerKt(crossinline block:(T?) -> Unit) {
        this.observe(this@BaseActivity, Observer { data ->
            block(data)
        })
    }

}