package com.zsa.demoapplication.bookmanager

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.contentValuesOf
import com.zsa.demoapplication.BaseMainActivity
import com.zsa.demoapplication.R
import kotlinx.android.synthetic.main.activity_add_book.*

class AddBookActivity : BaseMainActivity() {

    private var bookId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        btn_add_book.setOnClickListener {
            val inputName = input_name.text.toString()
            val inputAuthor = input_author.text.toString()
            val inputPrice = input_price.text.toString().toInt()
            val inputPage = input_page.text.toString().toInt()

            val uri =
                Uri.parse("content://com.zsa.demoapplication.bookManager.provider/book")
            val values = contentValuesOf(
                "name" to inputName,
                "author" to inputAuthor, "price" to inputPrice, "page" to inputPage
            )

            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)

            Toast.makeText(this, "添加成功，图书id:${bookId}", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}