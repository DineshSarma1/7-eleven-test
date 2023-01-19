package com.dinesh.testapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dinesh.testapplication.R
import com.dinesh.testapplication.data.Book
import com.dinesh.testapplication.databinding.ItemBookBinding

class BookAdapter(
    val bookList: MutableList<Book> = mutableListOf()
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

    inner class BookViewHolder(private val binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.book = book
        }
    }

    fun updateBooks(oldList: List<Book>) {
        bookList.clear()
        bookList.addAll(oldList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false))
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount(): Int = bookList.size

}