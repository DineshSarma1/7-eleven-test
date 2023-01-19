package com.dinesh.testapplication.repositories

import com.dinesh.testapplication.data.Book

interface BookRepository {
    suspend fun getBookList() : MutableList<Book>
}