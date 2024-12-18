package com.ndirawan.daily.ui.screen.detailTodo.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ndirawan.daily.data.repository.TodosRepository
import com.ndirawan.daily.model.Todos
import kotlinx.coroutines.launch

class TodosViewModel(private val todosRepository: TodosRepository) : ViewModel() {

    var todos by mutableStateOf(Todos())
        private set
    var isLoading by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun fetchTodos(){
        isLoading = true
        viewModelScope.launch {
            try {
                todos = todosRepository.getTodos()
            } catch (ex: Exception) {
                errorMessage = ex.message
            } finally {
                isLoading = false
            }
        }
    }
}