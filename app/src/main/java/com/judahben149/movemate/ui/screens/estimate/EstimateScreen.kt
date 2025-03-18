package com.judahben149.movemate.ui.screens.estimate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.R
import com.judahben149.movemate.ui.animation.AnimationDefaults
import com.judahben149.movemate.ui.components.ActionButton
import com.judahben149.movemate.ui.components.Screen
import com.judahben149.movemate.ui.components.SecondaryText
import com.judahben149.movemate.ui.theme.InProgressTextGreen

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
    onNavigateHome: () -> Unit,
    secondaryColour: Color = MaterialTheme.colorScheme.secondary,
    primaryColour: Color = MaterialTheme.colorScheme.primary
) {
    var animateComponents by remember { mutableStateOf(false) }
    var price by remember { mutableIntStateOf(1070) }
    val priceCounter by animateIntAsState(
        targetValue = price, animationSpec = tween(
            durationMillis = 1500, easing = FastOutSlowInEasing
        ), label = "price"
    )

    LaunchedEffect(Unit) {
        animateComponents = true
        price = 1460
    }

    Screen {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            AnimatedContent(shouldAnimate = animateComponents) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "MoveMate",
                        color = primaryColour,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                    Icon(
                        modifier = Modifier
                            .size(48.dp)
                            .padding(start = 8.dp, bottom = 2.dp),
                        painter = painterResource(id = R.drawable.ic_truck_orange),
                        contentDescription = null,
                        tint = secondaryColour
                    )
                }
            }
            AnimatedVisibility(
                visible = animateComponents, enter = scaleIn(
                    animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION)
                ) + fadeIn()
            ) {
                Icon(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.movemate_box),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.outline
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AnimatedContent(shouldAnimate = animateComponents) {
                    Text(
                        text = stringResource(R.string.total_estimated_amount),
                        fontSize = 26.sp
                    )
                }
                AnimatedContent(shouldAnimate = animateComponents) {
                    Text(
                        text = stringResource(id = R.string.estimated_price, priceCounter),
                        fontSize = 26.sp,
                        color = InProgressTextGreen
                    )
                }
                AnimatedContent(shouldAnimate = animateComponents) {
                    SecondaryText(
                        text = stringResource(id = R.string.estimate_description),
                        paddingValues = PaddingValues(top = 8.dp),
                        alignment = TextAlign.Center
                    )
                }
            }

            AnimatedContent(shouldAnimate = animateComponents) {
                ActionButton(
                    onButtonClick = onNavigateHome,
                    label = R.string.back_to_home,
                    labelFontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun AnimatedContent(
    shouldAnimate: Boolean,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = shouldAnimate,
        enter = slideInVertically(
            animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION),
            initialOffsetY = { fullHeight -> fullHeight * 2 })
                + fadeIn(animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION)),
    ) {
        content()
    }
}

@Preview
@Composable
fun EstimateScreenPreview() {
    EstimateScreen(modifier = Modifier, {}, {})
}