package com.zsa.demoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_single_instance_two.*

class SingleInstanceTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SecondActivity", "Task id is $taskId")
        Toast.makeText(this, "Task id is $taskId", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_single_instance_two)
        SingleInstanceTwo.setOnClickListener {
            val intent = Intent(this, SingleInstanceThridActivity::class.java)
            startActivity(intent)
        }
    }
}