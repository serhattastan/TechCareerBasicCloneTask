package com.cloffygames.techcareerbasicclonetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cloffygames.techcareerbasicclonetask.ui.theme.TechCareerBasicCloneTaskTheme
import com.cloffygames.techcareerbasicclonetask.uix.view.HomeScreen
import com.cloffygames.techcareerbasicclonetask.uix.view.ScreenTransition
import com.cloffygames.techcareerbasicclonetask.uix.viewmodel.HomeViewModel
import com.cloffygames.techcareerbasicclonetask.uix.viewmodel.MessageViewModel
import com.cloffygames.techcareerbasicclonetask.uix.viewmodel.UserMenuViewModel

class MainActivity : ComponentActivity() {
    private val messageViewModel = MessageViewModel()
    private val homeViewModel = HomeViewModel()
    private val userMenuViewModel = UserMenuViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TechCareerBasicCloneTaskTheme {
                ScreenTransition(homeViewModel, messageViewModel, userMenuViewModel)
            }
        }
    }
}