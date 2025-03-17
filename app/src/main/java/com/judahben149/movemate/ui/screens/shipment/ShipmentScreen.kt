package com.judahben149.movemate.ui.screens.shipment

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShipmentScreenRoute(
    onNavigateBack: () -> Unit
) {
    ShipmentScreen(
        onNavigateBack = onNavigateBack
    )
}

@Composable
fun ShipmentScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit
) {
    // Shipment Screen
}

@Preview
@Composable
fun ShipmentScreenPreview() {
    ShipmentScreen {}
}