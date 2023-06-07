package com.zsa.demoapplication.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class TestService : Service() {
    private val mBinder = DownloadBinder()

    class DownloadBinder : Binder() {
        private val MAX_PROGRESS = 100

        private var progress = 0

        interface OnProgressListener {
            fun onProgress(progress: Int)
        }

        private var onProgressListener: OnProgressListener? = null

        fun setOnProgressListener(onProgressListener: OnProgressListener?) {
            this.onProgressListener = onProgressListener
        }

        fun startDownload() {
            Log.d("MyService", "startDownload executed")

            Thread {
                while (progress < MAX_PROGRESS) {
                    progress += 10

                    //进度发生变化通知调用方
                    onProgressListener?.onProgress(progress)
                    try {
                        Thread.sleep(500)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }.start()

        }

        fun getProgress(): Int {
            return progress
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "onCreate executed")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d("MyService", "onStartCommand executed")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "onDestroy executed")
    }
}