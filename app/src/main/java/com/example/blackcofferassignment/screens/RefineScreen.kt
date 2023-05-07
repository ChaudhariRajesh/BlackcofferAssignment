package com.example.blackcofferassignment.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blackcofferassignment.ui.theme.BlackcofferAssignmentTheme
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

@ExperimentalMaterial3Api
@Composable
fun RefineScreen() {
    var text by remember { mutableStateOf("Hi community ! I am open to connections 😊.") }
    var sliderValue by remember {
        mutableStateOf(0f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 20.dp)
    ) {
        Text(text = "Select Your Availability")
        Spacer(modifier = Modifier.height(5.dp))
        DropDownMenu(
            items = arrayOf(
                "Available | Hey Let Us Connect",
                "Away | Stay Discrete And Watch",
                "Busy | Do Not Disturb | Will Catch Up Later",
                "SOS | Emergency! Need Assistance! HELP"
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Add Your Status")
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = text, onValueChange = {
                text = it
            },
            modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Select Hyper local Distance")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue_ ->
                sliderValue = sliderValue_
            },
            onValueChangeFinished = {

                Log.d("MainActivity", "sliderValue = $sliderValue")
            },
            valueRange = 0f..100f,
            steps = 0
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(text = "1 Km")
            val temp = sliderValue.toInt()
            Text(text = "$temp Km")
        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Select Purpose")

        FlowRow(modifier = Modifier.fillMaxWidth(),
        mainAxisAlignment = MainAxisAlignment.Center,
        mainAxisSpacing = 10.dp)
        {
            val state1 = remember { mutableStateOf(false) }
            FilterChip(
                selected = state1.value,
                onClick = { state1.value = !state1.value },
                label = { Text(text = "Coffee") },
                shape = RoundedCornerShape(50.dp)
            )
            val state2 = remember { mutableStateOf(false) }
            FilterChip(
                selected = state2.value,
                onClick = { state2.value = !state2.value },
                label = { Text(text = "Business") },
                shape = RoundedCornerShape(50.dp)
            )
            val state3 = remember { mutableStateOf(false) }
            FilterChip(
                selected = state3.value,
                onClick = { state3.value = !state3.value },
                label = { Text(text = "Hobbies") },
                shape = RoundedCornerShape(50.dp)
            )
            val state4 = remember { mutableStateOf(false) }
            FilterChip(
                selected = state4.value,
                onClick = { state4.value = !state4.value },
                label = { Text(text = "Friendship") },
                shape = RoundedCornerShape(50.dp)
            )
            val state5 = remember { mutableStateOf(false) }
            FilterChip(
                selected = state5.value,
                onClick = { state5.value = !state5.value },
                label = { Text(text = "Movies") },
                shape = RoundedCornerShape(50.dp)
            )
            val state6 = remember { mutableStateOf(false) }
            FilterChip(
                selected = state6.value,
                onClick = { state6.value = !state6.value },
                label = { Text(text = "Dinning") },
                shape = RoundedCornerShape(50.dp)
            )
            val state7 = remember { mutableStateOf(false) }
            FilterChip(
                selected = state7.value,
                onClick = { state7.value = !state7.value },
                label = { Text(text = "Dating") },
                shape = RoundedCornerShape(50.dp)
            )
            val state8 = remember { mutableStateOf(false) }
            FilterChip(
                selected = state8.value,
                onClick = { state8.value = !state8.value },
                label = { Text(text = "Matrimony") },
                shape = RoundedCornerShape(50.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {},
            shape = RoundedCornerShape(50.dp),
        modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Save & Explore")
        }
    }
}


@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BlackcofferAssignmentTheme {
        RefineScreen()
    }
}