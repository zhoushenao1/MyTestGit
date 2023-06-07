package com.zsa.demoapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.zsa.demoapplication.R

class ViewPager2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)
        val data = listOf(0, 1, 2, 3)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager)
        val myAdapter = ViewPager2Adapter()
        myAdapter.setList(data)
        viewPager2.adapter = myAdapter
    }
}