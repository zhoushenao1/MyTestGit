package com.zsa.demoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_single_task_one.*

class SingleTaskOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_task_one)
        SingleTaskOne.setOnClickListener {
            val intent = Intent(this, SingleTaskTwoActivity::class.java)
            startActivity(intent)
        }
    }
}