package com.judahben149.movemate.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.judahben149.movemate.domain.model.BottomTab

internal fun NavHostController.navigateToBottomTab(
    tab: BottomTab
) {
    navigate(tab.route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}