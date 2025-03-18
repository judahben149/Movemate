package com.judahben149.movemate.domain.model

data class Order(
    val id: String,
    val name: String,
    val sender: String,
    val receiver: String,
)