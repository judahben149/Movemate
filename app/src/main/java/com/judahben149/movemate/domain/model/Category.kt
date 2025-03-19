package com.judahben149.movemate.domain.model

import androidx.annotation.Keep

@Keep
data class Category(
    val name: String,
    var isSelected: Boolean = false
)
