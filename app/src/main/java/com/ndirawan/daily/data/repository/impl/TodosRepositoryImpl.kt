package com.ndirawan.daily.data.repository.impl

import com.ndirawan.daily.data.remote.ApiService
import com.ndirawan.daily.data.repository.TodosRepository
import com.ndirawan.daily.model.Todos

class TodosRepositoryImpl(private val apiService: ApiService) : TodosRepository {
    override suspend fun getTodos(): Todos {
        return apiService.getTodos()
    }
}