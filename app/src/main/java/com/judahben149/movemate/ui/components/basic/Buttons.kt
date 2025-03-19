package com.judahben149.movemate.ui.components.basic

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.R
import com.judahben149.movemate.ui.animation.AnimationDefaults

@Composable
fun BackButton(
    animateComponents: Boolean,
    navigateBack: () -> Unit
) {
    AnimatedVisibility(
        visible = animateComponents,
        enter = expandHorizontally() + fadeIn(animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION_500)),
        exit = fadeOut()
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 12.dp)
                .size(36.dp)
                .clickable { navigateBack() },
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    @StringRes label: Int,
    paddingValues: PaddingValues = PaddingValues(),
    labelFontSize: TextUnit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues),
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFFF58426)
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = stringResource(id = label),
            fontSize = labelFontSize
        )
    }
}

@Preview
@Composable
private fun BackButtonPreview() {
    BackButton(animateComponents = true, navigateBack = {})
}

@Preview
@Composable
private fun ActionButtonPreview() {
    ActionButton(
        onButtonClick = {},
        label = R.string.profile,
        labelFontSize = 22.sp
    )
}