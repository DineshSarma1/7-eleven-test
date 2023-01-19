package com.dinesh.testapplication.data

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("name")
    val name: String,
    @SerializedName("img")
    val img: String
) {
    //To load image using glide
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.context)
                .load(imageUrl)
                .into(view)
        }
    }
}

data class BookResponse(
    @SerializedName("items")
    val items: MutableList<Book>
)
