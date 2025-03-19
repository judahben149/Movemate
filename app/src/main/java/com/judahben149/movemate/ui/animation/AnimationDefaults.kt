package com.judahben149.movemate.ui.animation

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing

object AnimationDefaults {
    const val TWEEN_ANIMATION_DURATION_300 = 300
    const val TWEEN_ANIMATION_DURATION_500 = 500
    const val TWEEN_ANIMATION_DURATION_650 = 650
    const val TWEEN_ANIMATION_DURATION_1000 = 1000

    val AccelerateDecelerate7525Easing: Easing = CubicBezierEasing(0.8f, 0.9f, 0.95f, 1.0f)

}