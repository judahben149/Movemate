package com.judahben149.movemate.ui.screens.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.judahben149.movemate.data.mock.availableVehicles
import com.judahben149.movemate.data.mock.currentShipment
import com.judahben149.movemate.data.mock.orders
import com.judahben149.movemate.ui.components.Screen
import com.judahben149.movemate.ui.components.TrackingCard
import com.judahben149.movemate.ui.components.VehicleCarousel
import com.judahben149.movemate.ui.navigation.TopAppBar

@Composable
fun HomeScreenRoute(

) {
    HomeScreen()
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var isSearching by remember { mutableStateOf(false) }
    var allOrders by remember { mutableStateOf(orders) }

    Screen {
        Column {
            TopAppBar(
                isSearching = isSearching,
                onToggleSearch = { isSearching = !isSearching },
                onSearchOrder = { query ->
                    allOrders = orders.filter { it.id.contains(query, ignoreCase = true) }
                }
            )


            if (isSearching) {
                BackHandler {
                    isSearching = false
                }

                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    itemsIndexed(allOrders) { index, order ->
                        OrderItem(order = order)

                        if (index < allOrders.lastIndex) {
                            HorizontalDivider(modifier = Modifier.padding(horizontal = 12.dp))
                        }
                    }
                }
            } else {
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