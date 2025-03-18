package com.judahben149.movemate.data.mock

import com.judahben149.movemate.R
import com.judahben149.movemate.domain.enums.ShipmentStatus
import com.judahben149.movemate.domain.model.Order
import com.judahben149.movemate.domain.model.Shipment
import com.judahben149.movemate.domain.model.Vehicle

val orders = listOf(
    Order(
        id = "#NE43857340857904",
        name = "Macbook pro M2",
        sender = "Paris",
        receiver = "Morocco"
    ),
    Order(
        id = "#NEJ20089934122231",
        name = "Summer linen jacket",
        sender = "Barcelona",
        receiver = "Paris"
    ),
    Order(
        id = "#NEJ35870264978659",
        name = "Tapered-fit jeans AW",
        sender = "Columbia",
        receiver = "Paris"
    ),
    Order(
        id = "#NEJ35870264978659",
        name = "Slim fit jeans AW",
        sender = "Bogota",
        receiver = "Dhaka"
    ),
    Order(
        id = "#NEJ23481570754963",
        name = "Office setup desk",
        sender = "France",
        receiver = "Germany"
    )
)

val availableVehicles = listOf(
    Vehicle("Ocean freight", "International", R.drawable.ic_container_ship),
    Vehicle("Cargo freight", "Reliable", R.drawable.ic_haul_truck),
    Vehicle("Air freight", "International", R.drawable.ic_cargo_plane)
)

val currentShipment = Shipment(
    id = "NEJ20089934122231",
    name = "iPhone 15 Pro",
    sender = "Atlanta, 5243",
    receiver = "Chicago, 6342",
    status = ShipmentStatus.Pending,
    amount = "$1200.00",
    date = "8th Feb, 2024",
    timeline = "2 - 3 days"
)


val shipments = listOf(
    Shipment(
        id = "NEJ200899341222310",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.InProgress,
        amount = "$1400 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222311",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Pending,
        amount = "$650 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222312",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Pending,
        amount = "$650 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222313",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Loading,
        amount = "$230 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222314",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Loading,
        amount = "$230 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222315",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.InProgress,
        amount = "$370 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222316",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Pending,
        amount = "$370 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222317",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.InProgress,
        amount = "$3570 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222318",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Cancelled,
        amount = "$370 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222319",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Pending,
        amount = "$370 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ2008993412223110",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Completed,
        amount = "$370 USD",
        date = "Sep 20,2023",
        timeline = "2 - 3 days"
    )
)
