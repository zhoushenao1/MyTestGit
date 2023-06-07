package com.zsa.demoapplication.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zsa.demoapplication.R

class ViewPager2Adapter : RecyclerView.Adapter<ViewPager2Adapter.PagerViewHolder>() {
    private var mList: List<Int> = ArrayList()

    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mTextView: TextView = itemView.findViewById(R.id.tv_text)
        private var colors = arrayOf("#CCFF99", "#41F1E5", "#8D41F1", "#FF99CC")

        fun bindData(i: Int) {
            mTextView.text = "第${i + 1}个😃"
            mTextView.setBackgroundColor(Color.parseColor(colors[i]))
        }
    }

    fun setList(list: List<Int>) {
        mList = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPager2Adapter.PagerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_page, parent, false)
        return PagerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewPager2Adapter.PagerViewHolder, position: Int) {
        holder.bindData(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}