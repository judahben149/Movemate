package com.judahben149.movemate.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.judahben149.movemate.domain.enums.MoveMateScreens
import com.judahben149.movemate.ui.animation.AnimationDefaults.TWEEN_ANIMATION_DURATION
import com.judahben149.movemate.ui.screens.EstimateScreenRoute
import com.judahben149.movemate.ui.screens.calculate.CalculateScreenRoute
import com.judahben149.movemate.ui.screens.home.HomeScreenRoute
import com.judahben149.movemate.ui.screens.profile.ProfileScreenRoute
import com.judahben149.movemate.ui.screens.shipment.ShipmentScreenRoute

@Composable
fun MoveMateNavigation() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val topLevelRoutes = listOf(MoveMateScreens.HOME.name, MoveMateScreens.PROFILE.name)
    val shouldShowBottomBar = topLevelRoutes.contains(currentDestination?.route)

    Scaffold(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .navigationBarsPadding(),
        bottomBar = {
            BottomAppBar(
                currentDestination = currentDestination,
                onBottomTabSelected = navController::navigateToBottomTab,
                isVisible = shouldShowBottomBar
            )
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) { paddingValues ->

        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues),
            navController = navController,
            startDestination = MoveMateScreens.HOME.name
        ) {

            composable(
                route = MoveMateScreens.HOME.name,
                exitTransition = { fadeOut(animationSpec = tween(TWEEN_ANIMATION_DURATION)) }
            ) {
                HomeScreenRoute()
            }

            composable(MoveMateScreens.CALCULATE.name) {
                CalculateScreenRoute(
                    onNavigateBack = navController::navigateUp,
                    onCalculateClicked = { navController.navigate(MoveMateScreens.ESTIMATE.name) }
                )
            }
            composable(MoveMateScreens.SHIPMENT.name) {
                ShipmentScreenRoute(
                    onNavigateBack = navController::navigateUp
                )
            }

            composable(MoveMateScreens.PROFILE.name) {
                ProfileScreenRoute(
                    onNavigateBack = navController::navigateUp
                )
            }

            composable(MoveMateScreens.ESTIMATE.name) {
                EstimateScreenRoute(
                    onNavigateBack = navController::navigateUp,
                    onNavigateHome = { navController.navigate(MoveMateScreens.HOME.name) }
                )
            }
        }
    }
}