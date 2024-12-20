package com.ndirawan.daily.ui.screen.detailTodo.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ndirawan.daily.model.Todos
import com.ndirawan.daily.ui.component.SpacerOne
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
        Box(modifier =
            Modifier
                .fillMaxWidth()
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Detail(todos)
            when {
                isLoading -> {
                    CircularProgressIndicator()
                }
                error != null -> {
                    Text(error)
                }
            }
        }
    }
}

@Composable
fun Detail(todos: Todos){
    Card {
        Column(modifier =
            Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Text("Title : ${todos.title}")
            SpacerOne()
            Text("Id : ${todos.id}")
            SpacerOne()
            Text("User : ${todos.userId}")
            SpacerOne()
            Text("Completed : ${if (todos.completed == true) "yes" else "not"}")
        }
    }
}