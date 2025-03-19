package com.judahben149.movemate.domain.model

import androidx.annotation.Keep

@Keep
data class Order(
    val id: String,
    val name: String,
    val sender: String,
    val receiver: String,
)