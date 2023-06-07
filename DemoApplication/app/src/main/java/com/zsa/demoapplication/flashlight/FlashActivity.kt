package com.zsa.demoapplication.flashlight

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zsa.demoapplication.MainActivity
import com.zsa.demoapplication.R
import kotlinx.android.synthetic.main.activity_flash.*

class FlashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)
        supportActionBar?.hide()
        setBgAnimation(flash_bg, front_bg, title1, title2)
    }

    fun setBgAnimation(bg1: View, bg2: View, title1: View, title2: View) {
        val listener: AnimatorListenerAdapter
        val moveIn_bg1 = ObjectAnimator
            .ofFloat(bg1, "translationX", 0f, -350f, 0f)
        val moveIn_bg2 = ObjectAnimator
            .ofFloat(bg2, "translationX", 0f, -350f, 0f)
        val fadeIn_bg = ObjectAnimator
            .ofFloat(bg2, "alpha", 0.6f, 1f, 0.6f)


        val fadeIn1 = ObjectAnimator.ofFloat(title1, "alpha", 0.3f, 1f)
        val fadeIn2 = ObjectAnimator.ofFloat(title2, "alpha", 0.3f, 1f)

        val moveIn1 = ObjectAnimator
            .ofFloat(title1, "translationY", -40f, 0f)
        val moveIn2 = ObjectAnimator
            .ofFloat(title2, "translationY", 40f, 0f)

        val animator1 = AnimatorSet()
        val animator2 = AnimatorSet()
        animator1.play(fadeIn1).with(fadeIn2).with(moveIn1).with(moveIn2)
        animator1.duration = 10000

        animator2.play(moveIn_bg1).with(moveIn_bg2).with(fadeIn_bg)
        animator2.duration = 6000

        animator1.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                val intent = Intent(this@FlashActivity, MainActivity::class.java)
                startActivity(intent)
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {

            }
        })
        animator1.start()
        animator2.start()
    }
}

