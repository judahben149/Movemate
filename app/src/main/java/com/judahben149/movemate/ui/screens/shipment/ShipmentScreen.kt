package com.judahben149.movemate.ui.screens.shipment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.judahben149.movemate.R
import com.judahben149.movemate.data.mock.shipments
import com.judahben149.movemate.ui.animation.AnimationDefaults
import com.judahben149.movemate.ui.components.basic.LabelText
import com.judahben149.movemate.ui.components.basic.Screen

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
    var allShipments by remember { mutableStateOf(shipments) }

    var animateComponents by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    Screen {
        Column {
            ShipmentScreenAppBar(
                navigateBack = onNavigateBack,
                filterShipments = { status ->
                    allShipments = if (status != null) {
                        shipments.filter { it.status == status }
                    } else {
                        shipments
                    }
                },
            )
            LazyColumn {
                item {
                    AnimatedVisibility(
                        visible = animateComponents,
                        enter = slideInVertically(
                            animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION),
                            initialOffsetY = { fullHeight -> fullHeight * 2 })
                    ) {
                        LabelText(
                            textId = R.string.shipments,
                            paddingValues = PaddingValues(top = 16.dp, start = 24.dp)
                        )
                    }
                }
                items(allShipments) { shipment ->
                    ShipmentItemCard(shipment = shipment)
                }
            }
        }
    }

}

@Preview
@Composable
fun ShipmentScreenPreview() {
    ShipmentScreen {}
}