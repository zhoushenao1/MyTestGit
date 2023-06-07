package com.zsa.demoapplication.bookmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zsa.demoapplication.R

class BookAdapter(val BookList: List<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookName: TextView = view.findViewById(R.id.book_list_item_name)
        val bookAuthor: TextView = view.findViewById(R.id.book_list_item_author)
        val bookPrice: TextView = view.findViewById(R.id.book_list_item_price)
        val bookPage: TextView = view.findViewById(R.id.book_list_item_page)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_list_item, parent, false)
        val holder = ViewHolder(view)

        holder.itemView.setOnClickListener {
            val book = BookList[holder.adapterPosition]
            ItemMainActivity.actionStart(parent.context, book.id)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = BookList[position]

        holder.bookName.text = book.name
        holder.bookAuthor.text = book.author
        holder.bookPrice.text = book.price.toString()
        holder.bookPage.text = book.page.toString()
    }

    override fun getItemCount() = BookList.size
}