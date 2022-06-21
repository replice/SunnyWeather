package com.sunnyweather.android

import android.Manifest
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.ViewPropertyAnimator
import com.sunnyweather.android.databinding.ActivitySplashBinding
import com.sunnyweather.android.logic.utils.Function.hideStatusBar
import com.sunnyweather.android.ui.KTX.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    lateinit var animate: ViewPropertyAnimator



    override fun getLayoutRes(): Int = R.layout.activity_splash

    override fun initView() {
        super.initView()
        hideStatusBar(window)
        immersionStatusBar()

        animate = mBinding.ivLogo.animate()

        animate.apply {
            duration = 1200L
//            interpolator = BounceInterpolator()
            translationYBy(-80F)
            scaleXBy(0.2F)
            scaleYBy(0.2F)
        }
        Handler().postDelayed({
            redirectTo()
            },1500)

    }


    private fun redirectTo() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }



    override fun initData() {
        //To do sth.
    }

    override fun onDestroy() {
        super.onDestroy()
        animate.cancel()
    }
}