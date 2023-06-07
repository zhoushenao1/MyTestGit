package com.zsa.demoapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zsa.demoapplication.R

class UIMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uimain)
        val textList: List<String> = listOf("首页", "我的")
        val homeFragment: BlackFragment = BlackFragment()
        val myFragment: WhiteFragment = WhiteFragment()
        val fragmentList: List<Fragment> = listOf(homeFragment, myFragment)
        //初始化id
        val mainTab = findViewById<TabLayout>(R.id.tl_tab)
        val mainViewPage = findViewById<ViewPager2>(R.id.vp_container)
        mainViewPage.adapter = object : FragmentStateAdapter(this) {

            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }

        }
        val tabLayoutMediator =
            TabLayoutMediator(mainTab, mainViewPage) { tab: TabLayout.Tab, position: Int ->
                //设置文字
                tab.text = textList[position]
            }

        tabLayoutMediator.attach()
    }
}