package com.ndirawan.daily.data.remote

import com.ndirawan.daily.model.Todos
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        val client: ApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


    @GET("todos/1")
    suspend fun getTodos(): Todos
}