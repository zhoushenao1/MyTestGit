package com.zsa.demoapplication

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_other_uiactivity.*

class OtherUIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_uiactivity)
        setAnimation(mainTitle)
    }

    fun setAnimation(view: View) {
        val moveIn = ObjectAnimator.ofFloat(view, "translationX", -500f, 0f)
        val rotate = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f)
        val fadeInOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f)
        val animatorSet = AnimatorSet()
        animatorSet.play(rotate).with(fadeInOut).after(moveIn)
        animatorSet.duration = 5000
        animatorSet.start()
    }

}