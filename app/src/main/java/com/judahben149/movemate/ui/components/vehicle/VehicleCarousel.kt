package com.judahben149.movemate.ui.components.vehicle

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.judahben149.movemate.R
import com.judahben149.movemate.domain.model.Vehicle
import com.judahben149.movemate.ui.animation.AnimationDefaults
import com.judahben149.movemate.ui.components.basic.LabelText
import com.judahben149.movemate.ui.theme.Dimensions

@Composable
fun VehicleCarousel(vehicles: List<Vehicle>) {
    var animateComponents by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    AnimatedVisibility(
        visible = animateComponents,
        enter = slideInVertically(
            animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION),
            initialOffsetY = { fullHeight -> fullHeight * 2 }
        ) + fadeIn(
            animationSpec = tween(
                AnimationDefaults.TWEEN_ANIMATION_DURATION
            )
        ),
    ) {
        Column {
            LabelText(
                textId = R.string.available_vehicles,
                paddingValues = PaddingValues(
                    top = 24.dp,
                    start = Dimensions.HorizontalPadding
                )
            )
            Row(
                modifier = Modifier
                    .padding(top = Dimensions.VerticalPadding)
                    .horizontalScroll(rememberScrollState())
            ) {
                vehicles.forEachIndexed { index, vehicle ->
                    VehicleCard(
                        vehicle,
                        index == vehicles.size.minus(1)
                    )
                }
            }
        }
    }
}
