package com.ndirawan.daily.ui.screen.detailTodo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ndirawan.daily.data.repository.TodosRepository

class TodosViewModelFactory(private val todosRepository: TodosRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodosViewModel::class.java)){
            return modelClass.getConstructor(TodosRepository::class.java).newInstance(todosRepository)
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}