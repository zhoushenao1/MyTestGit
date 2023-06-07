package com.zsa.demoapplication

import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

open class BaseMainActivity : AppCompatActivity() {
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (null != this.currentFocus) {
            val mInputMethodManager: InputMethodManager =
                (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)!!
            return mInputMethodManager
                .hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
        }
        return super.onTouchEvent(event)
    }
}