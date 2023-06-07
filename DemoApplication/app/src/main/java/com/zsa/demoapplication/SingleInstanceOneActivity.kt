package com.zsa.demoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_single_instance_one.*

class SingleInstanceOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity", "Task id is $taskId")
        Toast.makeText(this, "Task id is $taskId", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_single_instance_one)
        SingleInstanceOne.setOnClickListener {
            val intent = Intent(this, SingleInstanceTwoActivity::class.java)
            startActivity(intent)
        }
    }
}