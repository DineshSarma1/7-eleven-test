package com.dinesh.testapplication.repositories

import com.dinesh.testapplication.data.Book
import com.dinesh.testapplication.data.BookService
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    val service: BookService
) : BookRepository {
    override suspend fun getBookList(): MutableList<Book> {
        return service.getBooks().items
    }
}