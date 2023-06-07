package com.zsa.demoapplication.broadcastpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.zsa.demoapplication.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()
            if (username == "admin" && password == "123456") {
                val intent = Intent(this, BroadcastMainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "用户名或密码输入错误", Toast.LENGTH_SHORT).show()
            }
        }
    }

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