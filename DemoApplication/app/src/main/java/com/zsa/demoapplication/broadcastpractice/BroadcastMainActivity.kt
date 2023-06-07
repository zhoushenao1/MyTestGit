package com.zsa.demoapplication.broadcastpractice

import android.content.Intent
import android.os.Bundle
import com.zsa.demoapplication.R
import kotlinx.android.synthetic.main.activity_broadcast_main.*

class BroadcastMainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_main)
        btn_loginback.setOnClickListener {
            val intent = Intent("com.zsa.demoapplication.BroadcastPractice.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }

}