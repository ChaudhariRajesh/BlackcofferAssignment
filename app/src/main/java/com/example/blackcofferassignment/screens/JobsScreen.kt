package com.example.blackcofferassignment.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JobsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchBar()
        CustomList(key = 2)
    }
}
