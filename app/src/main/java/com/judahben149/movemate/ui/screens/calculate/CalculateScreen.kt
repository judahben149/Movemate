package com.judahben149.movemate.ui.screens.calculate

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalculateScreenRoute(
    onNavigateBack: () -> Unit,
    onCalculateClicked: () -> Unit
) {
    CalculateScreen(
        onNavigateBack = onNavigateBack,
        onCalculateCLicked = onCalculateClicked
    )
}

@Composable
fun CalculateScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onCalculateCLicked: () -> Unit
) {
    // Calculate Screen
}

@Preview
@Composable
fun CalculateScreenPreview() {
    CalculateScreen(modifier = Modifier, {}, {})
}