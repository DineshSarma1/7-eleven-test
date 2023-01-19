package com.dinesh.testapplication.data

import retrofit2.Response
import retrofit2.http.GET

interface BookService {
    @GET("ad3d5c5c-e061-40f8-ac2b-6b46d54f2bf7")
    suspend fun getBooks() : BookResponse
}