package com.zsa.demoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_image_view.*

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        var count = 1;
        change.setOnClickListener {
            if (count++ % 2 == 1) {
                img.setImageResource(R.mipmap.img2)
            } else {
                img.setImageResource(R.mipmap.img1)
            }
        }
    }
}