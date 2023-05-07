package com.example.blackcofferassignment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import com.example.blackcofferassignment.R
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalUnitApi
@ExperimentalPagerApi
@Composable
fun ExploreScreen() {
    val scaffoldState = rememberScaffoldState()
    val list = listOf(
        R.drawable.ic_baseline_groups_24,
        R.drawable.ic_baseline_business_center_24,
        R.drawable.ic_baseline_store_24
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }
            , backgroundColor = Color(0xFF0A2E41),
            elevation = FloatingActionButtonDefaults.elevation()) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {
        CustomTabLayout(list)
    }

}


@ExperimentalUnitApi
@ExperimentalPagerApi
@Composable
fun CustomTabLayout(list: List<Int>) {

    val pagerState = rememberPagerState(pageCount = 3)
    Column() {
        TopAppBar(
            modifier = Modifier.fillMaxHeight(0f)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
        }
        Tabs(pagerState = pagerState, list)
        TabsContent(pagerState = pagerState)

    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState, list: List<Int>) {

    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                icon = {
                    Image(
                        painterResource(list[index]),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(30.dp)
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> NetworkScreen()
            1 -> JobsScreen()
            2 -> MerchantScreen()
        }
    }
}

