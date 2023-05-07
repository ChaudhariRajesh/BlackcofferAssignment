package com.example.blackcofferassignment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.blackcofferassignment.R

@Composable
fun SearchBar() {

    var text by remember { mutableStateOf("") }

    Row(
        Modifier.padding(25.dp, 10.dp, 25.dp, 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            placeholder = {
                Row() {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    Text(text = "Search Text")
                }
            },
            maxLines = 1,
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(50.dp))
                .clip(RoundedCornerShape(50.dp))
                .fillMaxWidth(0.87f),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )


        IconButton(
            onClick = {},
            Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)

        ) {
            Image(
                painterResource(R.drawable.ic_outline_tune_24),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(0.7f)
            )
        }
    }

}
