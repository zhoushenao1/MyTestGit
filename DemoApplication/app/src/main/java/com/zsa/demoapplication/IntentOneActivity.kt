package com.zsa.demoapplication

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent_one.*

class IntentOneActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_one)

        intent_btn1.setOnClickListener(this)
        intent_btn2.setOnClickListener {
            if (TextUtils.isEmpty(editText1.text.toString())) {
                Toast.makeText(this, "请先输入", Toast.LENGTH_SHORT).show()
            }
            if (it.resources.configuration.orientation
                == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            ) {
                this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            } else {
                this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
            }

        }
        alertDialog.setOnClickListener {
            if (TextUtils.isEmpty(editText1.text.toString())) {
                AlertDialog.Builder(this).apply {
                    setTitle("warning")
                    setMessage("抱歉，请先输入数字")
                    setCancelable(false)
                    setPositiveButton("好的") { _, _ ->
                        run {
                            val intent = Intent(this.context, IntentOneActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    show()
                }
            }
        }
        if (savedInstanceState != null) {
            val tempData = savedInstanceState.getInt("data_key")
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.intent_btn1 -> {
                Log.d("inputnumber", editText1.text.toString())
                Log.d(
                    "inputnumberisempty",
                    TextUtils.isEmpty(editText1.text.toString()).toString()
                )

                if (TextUtils.isEmpty(editText1.text.toString())) {
                    Toast.makeText(this, "请先输入数字", Toast.LENGTH_SHORT).show()
                } else {
                    val inputNumber = editText1.text.toString().toIntOrNull()
                    val intent = Intent(this, IntentTwoActivity::class.java)
                    intent.putExtra("inputNumber", inputNumber)
                    Log.d("inputnumber", inputNumber.toString())
                    startActivityForResult(intent, 1)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getIntExtra("data_return", 0)
                Toast.makeText(
                    this,
                    "返回的结果是：${returnedData}", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (!TextUtils.isEmpty(editText1.text.toString())) {
            val tempData = editText1.text.toString().toInt()
            outState.putInt("data_key", tempData)
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