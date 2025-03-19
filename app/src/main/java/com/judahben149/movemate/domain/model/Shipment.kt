package com.judahben149.movemate.domain.model

import androidx.annotation.Keep
import com.judahben149.movemate.domain.enums.ShipmentStatus

@Keep
data class Shipment(
    val id: String,
    val name: String,
    val sender: String,
    val receiver: String,
    val status: ShipmentStatus,
    val amount: String,
    val date: String,
    val timeline: String,
)