package com.dinesh.testapplication.di

import com.dinesh.testapplication.constant.Constants.BASE_URL
import com.dinesh.testapplication.data.BookService
import com.dinesh.testapplication.repositories.BookRepository
import com.dinesh.testapplication.repositories.BookRepositoryImpl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getRetrofitClient(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun getBookApiService(retrofit: Retrofit) : BookService {
        return retrofit.create(BookService::class.java)
    }

    @Singleton
    @Provides
    fun getBookRepository(bookService: BookService) : BookRepository {
        return BookRepositoryImpl(bookService)
    }
}