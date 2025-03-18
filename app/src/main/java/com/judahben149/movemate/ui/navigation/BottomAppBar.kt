package com.judahben149.movemate.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import com.judahben149.movemate.domain.enums.MoveMateScreens
import com.judahben149.movemate.domain.model.BottomTab
import com.judahben149.movemate.ui.components.BottomTabItem
import com.judahben149.movemate.ui.components.Indicator

@Composable
fun BottomAppBar(
    currentDestination: NavDestination?,
    onBottomTabSelected: (BottomTab) -> Unit,
    isVisible: Boolean,
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val indicatorWidth = (screenWidth / 4).dp
    var startingPoint by remember { mutableIntStateOf(0) }


    if (currentDestination?.route == MoveMateScreens.HOME.name) {
        startingPoint = 0
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            animationSpec = tween(800),
            initialOffsetY = { fullHeight -> fullHeight * 2 }),
        exit = slideOutVertically(
            animationSpec = tween(800),
            targetOffsetY = { fullHeight -> fullHeight * 2 })
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Indicator(
                width = indicatorWidth,
                startingPoint = startingPoint
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                NavDefaults.bottomTabs.forEach { tab ->

                    BottomTabItem(
                        modifier = Modifier.weight(1F),
                        tab = tab,
                        isSelected = currentDestination?.route == tab.route,
                        onTabSelected = {
                            startingPoint = getStartingPoint(screenWidth, tab.route)
                            onBottomTabSelected(tab)
                        }
                    )
                }
            }

        }
    }
}

fun getStartingPoint(screenWidth: Int, currentDestination: String): Int {
    return when (currentDestination) {
        NavDefaults.bottomTabs[1].route -> screenWidth / 4
        NavDefaults.bottomTabs[2].route -> (screenWidth / 4) * 2
        NavDefaults.bottomTabs[3].route -> (screenWidth / 4) * 3
        else -> 0
    }
}