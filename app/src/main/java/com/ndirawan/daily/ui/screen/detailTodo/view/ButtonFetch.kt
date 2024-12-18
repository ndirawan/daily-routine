package com.ndirawan.daily.ui.screen.detailTodo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ndirawan.daily.ui.screen.detailTodo.viewModel.TodosViewModel

@Composable
fun ButtonFetch(
    vm: TodosViewModel
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(onClick = { vm.fetchTodos() }) {
            Text("Fetch")
        }
    }
}