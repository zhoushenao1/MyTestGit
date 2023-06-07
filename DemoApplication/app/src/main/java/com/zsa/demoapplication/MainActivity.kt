package com.zsa.demoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zsa.demoapplication.broadcastpractice.LoginActivity
import com.zsa.demoapplication.contentprovider.CallPhoneActivity
import com.zsa.demoapplication.contentprovider.ReadContactsActivity
import com.zsa.demoapplication.flashlight.FlashActivity
import com.zsa.demoapplication.news.NewsMainActivity
import com.zsa.demoapplication.ui.LinerLayoutActivity
import com.zsa.demoapplication.ui.TabLayoutActivity
import com.zsa.demoapplication.ui.UIMainActivity
import com.zsa.demoapplication.ui.ViewPager2Activity
import com.zsa.demoapplication.bookmanager.BookMainActivity
import com.zsa.demoapplication.service.ServiceMainActivity
import com.zsa.demoapplication.service.TestActivity
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar?.hide()
        button_activity1.setOnClickListener {
            val intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }
        button_activity2.setOnClickListener {
            val intent = Intent(this, LaunchModeActivity::class.java)
            startActivity(intent)
        }
        button_activity3.setOnClickListener {
            val intent = Intent(this, IntentOneActivity::class.java)
            startActivity(intent)
        }
        button_activity4.setOnClickListener {
            val intent = Intent(this, IntentOneActivity::class.java)
            startActivity(intent)
        }
        button_fragment1.setOnClickListener {
            val intent = Intent(this, FragmentLifeCycle::class.java)
            startActivity(intent)
        }
        button_fragment2.setOnClickListener {
            val intent = Intent(this, NewsMainActivity::class.java)
            startActivity(intent)
        }
        button_service1.setOnClickListener {
            val intent = Intent(this, ServiceMainActivity::class.java)
            startActivity(intent)
        }
        button_service2.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }
        button_broadcast1.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        button_contentprovider1.setOnClickListener {
            val intent = Intent(this, CallPhoneActivity::class.java)
            startActivity(intent)
        }
        button_contentprovider2.setOnClickListener {
            val intent = Intent(this, ReadContactsActivity::class.java)
            startActivity(intent)
        }
        TabLayout1.setOnClickListener {
            val intent = Intent(this, TabLayoutActivity::class.java)
            startActivity(intent)
        }
        ViewPager.setOnClickListener {
            val intent = Intent(this, ViewPager2Activity::class.java)
            startActivity(intent)
        }
        tabwithview.setOnClickListener {
            val intent = Intent(this, UIMainActivity::class.java)
            startActivity(intent)
        }
        image.setOnClickListener {
            val intent = Intent(this, ImageViewActivity::class.java)
            startActivity(intent)
        }
        button_ui.setOnClickListener {
            val intent = Intent(this, FlashActivity::class.java)
            startActivity(intent)
        }
        layout.setOnClickListener {
            val intent = Intent(this, LinerLayoutActivity::class.java)
            startActivity(intent)
        }
        button_book.setOnClickListener {
            val intent = Intent(this, BookMainActivity::class.java)
            startActivity(intent)
        }
    }
}