package com.example.blackcofferassignment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.navigation.compose.rememberNavController
import com.example.blackcofferassignment.components.*
import com.example.blackcofferassignment.model.BottomNavigationMenuItemObject
import com.example.blackcofferassignment.model.DrawerNavigationMenuItemObject
import com.example.blackcofferassignment.ui.theme.BlackcofferAssignmentTheme
import com.example.blackcofferassignment.util.Screen
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalUnitApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackcofferAssignmentTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                Scaffold(

                    scaffoldState = scaffoldState,
                    topBar = {

                        AppBar(onNavigationIconClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }

                        })
                    },
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavigationMenuItemObject(
                                    image = R.drawable.ic_baseline_checklist_24,
                                    name = "Refine",
                                    route = Screen.RefineScreen.route
                                ),
                                BottomNavigationMenuItemObject(
                                    image = R.drawable.ic_baseline_remove_red_eye_24,
                                    name = "Explore",
                                    route = Screen.ExploreScreen.route
                                )
                            ),
                            navController = navController,
                            onItemCLick = {
                                navController.navigate(it.route!!)
                            }
                            )
                    },

                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                DrawerNavigationMenuItemObject(
                                    name = "Edit Profile",
                                    icon = Icons.Filled.Person,
                                ),
                                DrawerNavigationMenuItemObject(
                                    name = "My Network",
                                    icon = Icons.Filled.Info,
                                ),
                                DrawerNavigationMenuItemObject(
                                    name = "Switch to Professional",
                                    icon = Icons.Filled.Email,
                                ),
                                DrawerNavigationMenuItemObject(
                                    name = "Switch to Merchant",
                                    icon = Icons.Filled.ShoppingCart,
                                ),
                                DrawerNavigationMenuItemObject(
                                    name = "Business Cards",
                                    icon = Icons.Filled.AccountBox,
                                ),
                                DrawerNavigationMenuItemObject(
                                    name = "Live Locations",
                                    icon = Icons.Filled.LocationOn,
                                )
                            ), onItemClick = {
                                Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )
                    }


                ) {
                    Box(modifier = Modifier.padding(it)) {
                        BottomNavigationHost(navController)
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BlackcofferAssignmentTheme {
        Greeting("Android")
    }
}