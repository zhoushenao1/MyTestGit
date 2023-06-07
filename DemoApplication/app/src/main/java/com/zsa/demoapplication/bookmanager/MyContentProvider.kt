package com.zsa.demoapplication.bookmanager

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.net.Uri

class MyContentProvider : ContentProvider() {

    private val bookDir = 0
    private val bookItem = 1
    private val authority = "com.zsa.demoapplication.bookManager.provider"
    private var dbHelper: MyDataBaseHelper? = null

    private val uriMatcher by lazy {
        val matcher = UriMatcher(UriMatcher.NO_MATCH)
        matcher.addURI(authority, "book", bookDir)
        matcher.addURI(authority, "book/#", bookItem)
        matcher
    }

    override fun onCreate() = context?.let {
        dbHelper = MyDataBaseHelper(it, "BookManager.db", 2)
        true
    } ?: false

    override fun delete(
        uri: Uri, selection: String?,
        selectionArgs: Array<String>?
    ) = dbHelper.let {
        val db = it?.writableDatabase

        val deleteRows = when (uriMatcher.match(uri)) {
            bookDir -> {
                db?.delete("Book", selection, selectionArgs)
            }
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db?.delete("Book", "id = ?", arrayOf(bookId))
            }
            else -> 0
        }
        deleteRows
    } ?: 0

    override fun insert(uri: Uri, values: ContentValues?) = dbHelper.let {
        val db = it?.writableDatabase

        val uriReturn = when (uriMatcher.match(uri)) {
            bookItem, bookDir -> {
                val newBookId = db?.insert("Book", null, values)
                Uri.parse("content://$authority/book/$newBookId")
            }
            else -> null
        }
        uriReturn
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ) = dbHelper.let {
        val db = it?.readableDatabase

        val cursor = when (uriMatcher.match(uri)) {
            bookDir -> {
                db?.query(
                    "Book", projection, selection, selectionArgs,
                    null, null, sortOrder
                )
            }
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db?.query(
                    "Book", projection, "id = ?", arrayOf(bookId),
                    null, null, sortOrder
                )
            }
            else -> null
        }
        cursor
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ) = dbHelper.let {
        val db = it?.writableDatabase

        val updatedRows = when (uriMatcher.match(uri)) {
            bookDir -> {
                db?.update("Book", values, selection, selectionArgs)
            }
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db?.update("Book", values, "id = ?", arrayOf(bookId))
            }
            else -> null
        }
        updatedRows
    } ?: 0

    override fun getType(uri: Uri) = when (uriMatcher.match(uri)) {
        bookDir -> "vnd.android.cursor.dir/vnd.$authority.book"
        bookItem -> "vnd.android.cursor.item/vnd.$authority.book"
        else -> null
    }
}