package com.ndirawan.daily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ndirawan.daily.data.remote.ApiService
import com.ndirawan.daily.data.repository.impl.TodosRepositoryImpl
import com.ndirawan.daily.ui.screen.detailTodo.view.TodosScreen
import com.ndirawan.daily.ui.screen.detailTodo.viewModel.TodosViewModel
import com.ndirawan.daily.ui.screen.detailTodo.viewModel.TodosViewModelFactory
import com.ndirawan.daily.ui.theme.DailyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyTheme {
                val vm: TodosViewModel = viewModel(factory = TodosViewModelFactory(TodosRepositoryImpl(ApiService.client)))
                TodosScreen(vm)
            }
        }
    }
}