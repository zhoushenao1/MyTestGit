package com.zsa.demoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class IntentTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)
        AlertDialog.Builder(this).apply {
            val input = intent.getIntExtra("inputNumber", 0)
            val result = input * input
            setTitle("计算完成")
            setMessage("计算结果为：${result},是否返回数据到上一层")
            setPositiveButton("OK") { _, _ ->
                run {
                    val intent = Intent()
                    intent.putExtra("data_return", result)
                    setResult(RESULT_OK, intent)
                    finish()
                }

            }

        }.show()
    }
}