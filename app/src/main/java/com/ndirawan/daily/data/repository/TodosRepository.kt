package com.ndirawan.daily.data.repository

import com.ndirawan.daily.model.Todos

interface TodosRepository {
    suspend fun getTodos(): Todos
}