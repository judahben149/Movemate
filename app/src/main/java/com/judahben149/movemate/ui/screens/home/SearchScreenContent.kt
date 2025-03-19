package com.judahben149.movemate.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.judahben149.movemate.domain.model.Order

@Composable
fun SearchScreenContent(allOrders: List<Order>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        items(
            count = allOrders.size,
            key = { index -> allOrders[index].name },
            itemContent = { index ->
                val order = allOrders[index]
                OrderItem(order = order)
                if (index < allOrders.lastIndex) {
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 12.dp))
                }
            }
        )
    }
}