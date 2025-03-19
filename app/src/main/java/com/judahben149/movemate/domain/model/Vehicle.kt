package com.judahben149.movemate.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.Keep

@Keep
data class Vehicle(
    val freight: String,
    val category: String,
    @DrawableRes val icon: Int
)