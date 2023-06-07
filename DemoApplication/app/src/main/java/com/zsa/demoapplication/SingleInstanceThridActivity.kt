package com.zsa.demoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class SingleInstanceThridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ThirdActivity", "Task id is $taskId")
        Toast.makeText(this, "Task id is $taskId", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_single_instance_thrid)
    }
}