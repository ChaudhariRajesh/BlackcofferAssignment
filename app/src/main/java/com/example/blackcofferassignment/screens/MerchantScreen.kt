package com.example.blackcofferassignment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.blackcofferassignment.R

@Composable
fun MerchantScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar()
        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painterResource(id = R.drawable.emptybox),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(0.2f)
            )
            Text(text = "Your explore list is EMPTY", fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Sorry, we could not find any user near you.\nTry increasing your search radius", maxLines = 2, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {},
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth(0.7f)) {
                Text("INCREASE RADIUS")
            }
        }
    }
}
