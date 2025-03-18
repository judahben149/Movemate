package com.judahben149.movemate.ui.components.basic

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.judahben149.movemate.ui.theme.Dimensions

@Composable
fun AdjustableDivider(horizontalPadding: Dp = 0.dp) {

    HorizontalDivider(
        modifier = Modifier.padding(
            vertical = Dimensions.VerticalPadding,
            horizontal = Dimensions.HorizontalPadding
        ),
        color = Color.Gray.copy(alpha = 0.2F)
    )
}