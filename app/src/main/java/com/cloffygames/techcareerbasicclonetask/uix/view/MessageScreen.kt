package com.cloffygames.techcareerbasicclonetask.uix.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.cloffygames.techcareerbasicclonetask.ui.theme.CustomLightBlue
import com.cloffygames.techcareerbasicclonetask.uix.viewmodel.MessageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageScreen(messageViewModel: MessageViewModel, navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Mesajlar") },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = CustomLightBlue)
            )}
    ){ paddingValues ->

        Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {

            Text(text = "Mesajlar Sayfası")

        }
    }

}