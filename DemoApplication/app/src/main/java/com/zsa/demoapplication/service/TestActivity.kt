package com.zsa.demoapplication.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.zsa.demoapplication.R
import com.zsa.demoapplication.service.TestService.DownloadBinder.OnProgressListener
import kotlinx.android.synthetic.main.activity_test.*


class TestActivity : AppCompatActivity() {
    lateinit var downloadBinder: TestService.DownloadBinder
    private var mProgressBar: ProgressBar? = null
    private var isBind: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        mProgressBar = findViewById<View>(R.id.mProgressBar) as ProgressBar
        //绑定Service
        mbutton.setOnClickListener {
            tip.text = "下载中..."
            val intent = Intent(this, TestService::class.java)
            bindService(intent, conn, BIND_AUTO_CREATE)
            isBind = true
        }
    }

    private val conn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            downloadBinder = service as TestService.DownloadBinder
            downloadBinder.setOnProgressListener(object : OnProgressListener {
                override fun onProgress(progress: Int) {
                    mProgressBar?.progress = progress
                    if (progress == 100) {
                        tip.post {
                            tip.text = "下载完成"
                        }
                    }
                }
            })
            downloadBinder.startDownload()
        }

        override fun onServiceDisconnected(name: ComponentName) {
        }
    }

    override fun onDestroy() {
        if (isBind) {
            unbindService(conn)
        }
        super.onDestroy()
    }
}