package com.ndirawan.daily.ui.screen.detailTodo.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ndirawan.daily.ui.screen.detailTodo.viewModel.TodosViewModel

@Composable
fun TodosScreen(vm: TodosViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Content(vm)
        ButtonFetch(vm)
    }
}

@Composable
fun Content(vm: TodosViewModel){
    val todos = vm.todos
    val isLoading = vm.isLoading
    val error = vm.errorMessage
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier =
            Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else if (error != null) {
                Text(error)
            } else {
                Text(todos.title ?: "Empty")
                Text(todos.userId.toString())
                Text(todos.id.toString())
                Text(todos.completed.toString())
            }
        }
    }
}
