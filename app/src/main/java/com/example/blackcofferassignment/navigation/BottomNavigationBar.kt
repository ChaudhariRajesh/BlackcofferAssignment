package com.example.blackcofferassignment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.blackcofferassignment.util.Screen
import com.example.blackcofferassignment.model.BottomNavigationMenuItemObject
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterial3Api
@ExperimentalPagerApi
@ExperimentalUnitApi
@Composable
fun BottomNavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.ExploreScreen.route) {
        composable(route = Screen.RefineScreen.route)
        {
            RefineScreen()
        }
        composable(route = Screen.ExploreScreen.route)
        {
            ExploreScreen()
        }
    }

}


@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationMenuItemObject>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemCLick: (BottomNavigationMenuItemObject) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    androidx.compose.material.BottomNavigation(
        modifier = modifier,
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selected,
                onClick = { onItemCLick(item) },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {

                        Image(
                            painterResource(item.image),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(30.dp)
                        )
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 13.sp
                        )
                    }

                })
        }
    }
}