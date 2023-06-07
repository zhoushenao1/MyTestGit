package com.zsa.demoapplication.bookmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.contentValuesOf
import com.zsa.demoapplication.R
import kotlinx.android.synthetic.main.activity_book_main.*

class BookMainActivity : AppCompatActivity() {

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_main)

        btn_createDB.setOnClickListener {
            // 添加数据
            val uri =
                Uri.parse("content://com.zsa.demoapplication.bookManager.provider/book")

            for (i in 1..20) {
                val page = (500..800).random()
                val price = (19..29).random() + 0.99
                val values = contentValuesOf(
                    "name" to "西游记第 ${i} 版",
                    "author" to "吴承恩${i}号", "page" to page, "price" to price
                )
                contentResolver.insert(uri, values)
            }
        }

        btn_addBook.setOnClickListener {
            val intent = Intent(this, AddBookActivity::class.java)
            startActivity(intent)
        }

        btn_listBook.setOnClickListener {
            val intent = Intent(this, BookListActivity::class.java)
            startActivity(intent)
        }

        btn_updateDB.setOnClickListener {
            val uri =
                Uri.parse("content://com.zsa.demoapplication.bookManager.provider/book")
            contentResolver.delete(uri, null, null)
        }
    }
}