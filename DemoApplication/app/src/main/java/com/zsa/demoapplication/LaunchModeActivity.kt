package com.zsa.demoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launch_mode.*

class LaunchModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_mode)
        supportActionBar?.hide()
        startStandardActivity.setOnClickListener {
            val intent = Intent(this, StandardActivity::class.java)
            startActivity(intent)
        }
        startSingleTopActivity.setOnClickListener {
            val intent = Intent(this, SingleTopActivity::class.java)
            startActivity(intent)
        }
        startSingleTaskActivity.setOnClickListener {
            val intent = Intent(this, SingleTaskOneActivity::class.java)
            startActivity(intent)
        }
        startSingleInstanceActivity.setOnClickListener {
            val intent = Intent(this, SingleInstanceOneActivity::class.java)
            startActivity(intent)
        }
    }
}