package com.judahben149.movemate.ui.screens.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreenRoute(
    onNavigateBack: () -> Unit
) {
    ProfileScreen(
        onNavigateBack = onNavigateBack
    )
}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit
) {

}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen {}
}

