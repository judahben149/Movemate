package com.judahben149.movemate.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EstimateScreenRoute(
    onNavigateBack: () -> Unit,
    onNavigateHome: () -> Unit
) {
    EstimateScreen(
        onNavigateBack = onNavigateBack,
        onNavigateHome = onNavigateHome
    )
}

@Composable
fun EstimateScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onNavigateHome: () -> Unit
) {
    // Estimate Screen
}

@Preview
@Composable
fun EstimateScreenPreview() {
    EstimateScreen(modifier = Modifier, {}, {})
}