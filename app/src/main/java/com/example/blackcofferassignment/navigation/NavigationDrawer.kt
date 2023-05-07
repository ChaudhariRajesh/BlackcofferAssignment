package com.example.blackcofferassignment.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackcofferassignment.model.DrawerNavigationMenuItemObject

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .background(Color(0xFFBCDCF5))
            .padding(35.dp, 20.dp, 20.dp, 5.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        IconButton(onClick = {},
            modifier = Modifier.align(
            Alignment.TopEnd))
        {
            Icon(imageVector = Icons.Default.Settings, contentDescription = null)
        }
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.align(Alignment.TopStart)
            ) {
            Icon(
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.Start)
                    .background(Color.Transparent)
                    .border(2.dp, Color.Black, RoundedCornerShape(50.dp))
                    .clip(RoundedCornerShape(50.dp)),
                imageVector = Icons.Default.Person,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "User Name", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Text(text = "USERID", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(5.dp))
            LinearProgressIndicator(
                progress = 0.3f, modifier = Modifier
                    .fillMaxWidth(0.35f)
                    .height(10.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Available", fontSize = 15.sp)
        }
    }
}


@Composable
fun DrawerBody(
    items: List<DrawerNavigationMenuItemObject>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 17.sp),
    onItemClick: (DrawerNavigationMenuItemObject) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(20.dp, 15.dp)
            ) {
                Icon(imageVector = item.icon, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.name,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

}