package com.judahben149.movemate.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.Keep

@Keep
data class BottomTab (
    val id: Int,
    val route: String,

    @DrawableRes
    val icon: Int
)