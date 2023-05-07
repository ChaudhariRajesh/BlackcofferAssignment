package com.example.blackcofferassignment.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)

            }
        },
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.9f)
                        .padding(0.dp, 5.dp)
                ) {
                    Text(text = "Howdy User Name !!")
                    Row() {
                        Icon(
                            imageVector = Icons.Default.LocationOn, contentDescription = null,
                            modifier = Modifier.size(15.dp)
                        )
                        Text(text = "Location", fontSize = 10.sp)
                    }

                }

                Icon(
                    imageVector = Icons.Default.Notifications, contentDescription = null,
                    modifier = Modifier.weight(0.1f)
                )
            }
        },
    )
}