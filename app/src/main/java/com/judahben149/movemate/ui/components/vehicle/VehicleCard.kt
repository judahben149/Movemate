package com.judahben149.movemate.ui.components.vehicle

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.judahben149.movemate.R
import com.judahben149.movemate.domain.model.Vehicle
import com.judahben149.movemate.ui.animation.AnimationDefaults
import com.judahben149.movemate.ui.theme.Dimensions

@Composable
fun VehicleCard(
    vehicle: Vehicle,
    isLastItem: Boolean = false
) {
    var animateComponents by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    Column(
        modifier = Modifier
            .size(height = 230.dp, width = 210.dp)
            .padding(start = Dimensions.Padding16)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(Dimensions.Padding16)
            )
            .padding(top = 24.dp, start = 24.dp)

            .clipToBounds()
    ) {
        Text(
            text = vehicle.freight,
            fontSize = 18.sp,
        )

        Text(
            text = vehicle.category,
            color = Gray,
            fontSize = 13.sp
        )

        AnimatedVisibility(
            visible = animateComponents,
            enter = slideIn(
                initialOffset = { fullSize ->
                    val distanceX = fullSize.width * 3
                    val distanceY = -fullSize.height * 2
                    IntOffset(
                        x = distanceX,
                        y = distanceY
                    )
                },
                animationSpec = tween(durationMillis = AnimationDefaults.TWEEN_ANIMATION_DURATION_650)
            )
        ) {
            AsyncImage(
                model = vehicle.icon,
                contentDescription = null,
                modifier = Modifier
                    .size(108.dp)
                    .scale(1.3f)
                    .offset(x = 48.dp, y = (-16).dp)
            )
        }

        if (isLastItem) {
            Spacer(modifier = Modifier.width(Dimensions.Padding16))
        }
    }
}

@Preview
@Composable
fun VehicleCardPreview() {
    Box(
        modifier = Modifier
            .background(Gray)
            .fillMaxSize()
    ) {
        VehicleCard(Vehicle("Ocean freight", "International", R.drawable.ic_container_ship))
    }
}
