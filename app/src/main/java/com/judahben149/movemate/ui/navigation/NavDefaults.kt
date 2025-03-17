package com.judahben149.movemate.ui.navigation

import com.judahben149.movemate.R
import com.judahben149.movemate.domain.enums.MoveMateScreens
import com.judahben149.movemate.domain.model.BottomTab

object NavDefaults {

    val bottomTabs = listOf(
        BottomTab(
            id = R.string.home,
            icon = R.drawable.ic_home,
            route = MoveMateScreens.HOME.name
        ),
        BottomTab(
            id = R.string.calculate,
            icon = R.drawable.ic_calculate,
            route = MoveMateScreens.CALCULATE.name
        ),
        BottomTab(
            id = R.string.shipment,
            icon = R.drawable.ic_shipment,
            route = MoveMateScreens.SHIPMENT.name
        ),
        BottomTab(
            id = R.string.profile,
            icon = R.drawable.ic_profile,
            route = MoveMateScreens.PROFILE.name
        )
    )
}