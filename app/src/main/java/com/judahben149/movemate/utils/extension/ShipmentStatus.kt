package com.judahben149.movemate.utils.extension

import com.judahben149.movemate.domain.enums.ShipmentStatus

fun ShipmentStatus.friendlyText(): String {

    return when (this) {
        ShipmentStatus.InProgress -> "in-progress"
        ShipmentStatus.Completed -> "completed"
        ShipmentStatus.Pending -> "pending"
        ShipmentStatus.Cancelled -> "cancelled"
        ShipmentStatus.Loading -> "loading"
    }
}