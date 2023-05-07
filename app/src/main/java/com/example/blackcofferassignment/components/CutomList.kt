package com.example.blackcofferassignment.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.FilledIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
//key = 1, when list will not have buttons
//key = 2, when list will have buttons
fun CustomList(key: Int) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(5) {
            ListItem(key)

        }
    }
}


@Composable
fun ListItem(key: Int) {

    var topPadding = 15

    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Card(
            modifier = Modifier
                .align(CenterEnd)
                .fillMaxWidth(0.93f),
            shape = RoundedCornerShape(CornerSize(20.dp)),
            elevation = 4.dp
        ) {
            Column(

            ) {
                Spacer(modifier = Modifier.height(10.dp))

                TextButton(onClick = {}, modifier = Modifier.align(Alignment.End)) {
                    Text(
                        text = "+ INVITE",
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(90.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    Text(
                        text = "User Name",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.background(Color.Transparent)
                    )
                    Text(
                        text = "Jalgaon, within 34.3 KM",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(0.dp, 0.dp, 0.dp, 10.dp)
                    )
                    LinearProgressIndicator(
                        progress = 0.2f, modifier = Modifier
                            .fillMaxWidth(0.35f)
                            .height(15.dp)
                            .padding(0.dp, 0.dp, 0.dp, 5.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    if (key == 2) {
                        Row() {
                            FilledIconButton(
                                onClick = {}
                            ) {
                                Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                            }
                            FilledIconButton(
                                onClick = {},
                            ) {
                                Icon(imageVector = Icons.Default.Person, contentDescription = null)
                            }
                        }
                        topPadding = 0
                    }

                }

                Column(
                    modifier = Modifier.padding(30.dp, topPadding.dp, 0.dp, 0.dp)
                ) {
                    Text(
                        text = "Coffee | Business | Friendship",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.background(Color.Transparent)
                    )
                    Text(
                        text = "Hi community ! I am open to connections 😊😊😊.",
                        fontSize = 14.sp,
                        modifier = Modifier.background(Color.Transparent)
                    )

                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }

        Card(
            modifier = Modifier
                .align(TopStart)
                .offset(10.dp, 30.dp)
                .fillMaxSize(0.21f),
            shape = RoundedCornerShape(CornerSize(10.dp)),
            elevation = 30.dp,
            backgroundColor = Color(0xFF547387)
        ) {
            Text(
                text = "UN",
                fontSize = 35.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(5.dp, 19.dp)

            )

        }


    }


}

