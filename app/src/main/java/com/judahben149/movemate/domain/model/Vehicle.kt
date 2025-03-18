package com.judahben149.movemate.domain.model

import androidx.annotation.DrawableRes

data class Vehicle(
    val freight: String,
    val category: String,
    @DrawableRes val icon: Int
)