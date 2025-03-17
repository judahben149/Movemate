package com.judahben149.movemate.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.judahben149.movemate.ui.animation.AnimationDefaults.TWEEN_ANIMATION_DURATION
import com.judahben149.movemate.ui.theme.SelectedBottomBarColor

@Composable
fun Indicator(
    width: Dp,
    startingPoint: Int
) {

    val newPosition = with(LocalDensity.current) {
        startingPoint.dp.toPx().toInt()
    }

    val offset by animateIntOffsetAsState(
        targetValue = IntOffset(x = newPosition, y = 0),
        animationSpec = tween(
            durationMillis = TWEEN_ANIMATION_DURATION,
            easing = FastOutSlowInEasing
        ),
        label = "offset"
    )

    Box(
        modifier = Modifier
            .offset { offset }
            .background(color = SelectedBottomBarColor)
            .size(width = width, height = 4.dp)
    )
}