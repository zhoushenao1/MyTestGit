package com.zsa.demoapplication.bookmanager

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zsa.demoapplication.R
import kotlinx.android.synthetic.main.activity_book_list.*


class BookListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        val layoutManager = LinearLayoutManager(this)
        bookListRecyclerView.layoutManager = layoutManager
    }

    override fun onStart() {
        super.onStart()

        val adapter = BookAdapter(getBook())
        bookListRecyclerView.adapter = adapter
    }

    @SuppressLint("Range")
    private fun getBook(): List<Book> {
        val bookList = ArrayList<Book>()

        // 查询数据
        val uri =
            Uri.parse("content://com.zsa.demoapplication.bookManager.provider/book")
        contentResolver.query(
            uri,
            null, null, null, null
        )?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndex("id"))
                val name = getString(getColumnIndex("name"))
                val author = getString(getColumnIndex("author"))
                val pages = getInt(getColumnIndex("page"))
                val price = getDouble(getColumnIndex("price"))
                val book = Book(id, name, author, price, pages)

                bookList.add(book)

                Log.d("MainActivity", "book name is $name")
                Log.d("MainActivity", "book id is $id")
            }

            close()
        }

        return bookList
    }
}