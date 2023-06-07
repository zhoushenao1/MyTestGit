package com.zsa.demoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_single_task_one.*
import kotlinx.android.synthetic.main.activity_single_task_two.*

class SingleTaskTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_task_two)
        SingleTaskTwo.setOnClickListener {
            val intent = Intent(this, SingleTaskOneActivity::class.java)
            startActivity(intent)
        }
    }
}