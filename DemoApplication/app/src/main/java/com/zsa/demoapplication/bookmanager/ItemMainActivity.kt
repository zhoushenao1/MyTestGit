package com.zsa.demoapplication.bookmanager

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.contentValuesOf
import com.zsa.demoapplication.R
import kotlinx.android.synthetic.main.activity_item_main.*

class ItemMainActivity : AppCompatActivity() {

    companion object {
        fun actionStart(context: Context, bookId: Int) {
            val intent = Intent(context, ItemMainActivity::class.java).apply {
                putExtra("bookId", bookId.toString())
            }

            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_main)

        val bookId = intent.getStringExtra("bookId")

        btn_updateBook.setOnClickListener {
            bookId.let {
                val uri = Uri.parse(
                    "content://com.zsa.demoapplication.bookManager.provider/" +
                            "book/$it"
                )
                val values = contentValuesOf(
                    "name" to "Update Name", "author" to "Nobody",
                    "page" to 1234, "price" to 12.34
                )
                contentResolver.update(uri, values, "id = ?", arrayOf(bookId))
            }

            Toast.makeText(this, "更新成功", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, BookListActivity::class.java)
            startActivity(intent)
        }

        btn_delBook.setOnClickListener {
            bookId.let {
                val uri = Uri.parse(
                    "content://com.zsa.demoapplication.bookManager.provider/" +
                            "book/$it"
                )
                contentResolver.delete(uri, "id = ?", arrayOf(bookId))
            }

            Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, BookListActivity::class.java)
            startActivity(intent)
        }
    }
}
