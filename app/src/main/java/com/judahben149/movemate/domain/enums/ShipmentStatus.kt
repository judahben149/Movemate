package com.judahben149.movemate.domain.enums

import androidx.annotation.Keep

@Keep
enum class ShipmentStatus {
    Completed,
    InProgress,
    Pending,
    Cancelled,
    Loading
}