package com.judahben149.movemate.ui.screens.home

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.judahben149.movemate.data.mock.availableVehicles
import com.judahben149.movemate.data.mock.currentShipment
import com.judahben149.movemate.data.mock.orders
import com.judahben149.movemate.ui.animation.AnimationDefaults.AccelerateDecelerate7525Easing
import com.judahben149.movemate.ui.animation.ContentAnimatedVisibility
import com.judahben149.movemate.ui.components.basic.Screen
import com.judahben149.movemate.ui.components.home.TrackingCard
import com.judahben149.movemate.ui.components.vehicle.VehicleCarousel
import com.judahben149.movemate.ui.navigation.TopAppBarWithMotion

@Composable
fun HomeScreenRoute(

) {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    var isSearching by remember { mutableStateOf(false) }
    var allOrders by remember { mutableStateOf(orders) }

    Screen {
        Column {
            TopAppBarWithMotion(
                isSearching = isSearching,
                onToggleSearch = { isSearching = !isSearching },
                onSearchOrder = { query ->
                    allOrders = orders.filter { it.id.contains(query, ignoreCase = true) }
                }
            )

            AnimatedVisibility(
                visible = isSearching,
                enter = slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight/4 },
                    animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                ) + fadeIn(
                    initialAlpha = 0f,
                    animationSpec = tween(durationMillis = 400, easing = AccelerateDecelerate7525Easing)
                ),
                exit = slideOutVertically(
                    targetOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(durationMillis = 200, easing = LinearOutSlowInEasing)
                ) + fadeOut(
                    targetAlpha = 0f,
                    animationSpec = tween(durationMillis = 100, easing = LinearOutSlowInEasing)
                )
            ) {
                BackHandler { isSearching = false }
                SearchScreenContent(allOrders = allOrders)
            }

            if (!isSearching) {
                LazyColumn {
                    item { TrackingCard(currentShipment = currentShipment) }
                    item { VehicleCarousel(vehicles = availableVehicles) }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}