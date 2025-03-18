package com.judahben149.movemate.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.R
import com.judahben149.movemate.ui.animation.AnimationDefaults
import com.judahben149.movemate.ui.components.basic.BackButton
import com.judahben149.movemate.ui.components.home.SearchRow
import com.judahben149.movemate.ui.theme.Dimensions
import com.judahben149.movemate.ui.theme.Dimensions.Padding4
import com.judahben149.movemate.ui.theme.Dimensions.ProfileIconSize

@Composable
fun TopAppBar(
    isSearching: Boolean,
    onToggleSearch: () -> Unit,
    onSearchOrder: (String) -> Unit,
) {
    var animateComponents by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    AnimatedVisibility(
        visible = animateComponents,
        enter = slideInVertically(
            animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION),
            initialOffsetY = { fullHeight -> -fullHeight }),
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFF543b9b))
                .animateContentSize(
                    animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION)
                )
                .fillMaxWidth()
        ) {
            AnimatedVisibility(
                visible = !isSearching,
                enter = slideInVertically() + fadeIn(),
                exit = slideOutVertically() + fadeOut(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = Dimensions.VerticalPadding,
                            start = Dimensions.HorizontalPadding,
                            end = Dimensions.HorizontalPadding
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(ProfileIconSize)
                            .clip(CircleShape)
                    )
                    Column(
                        modifier = Modifier.padding(start = Dimensions.HorizontalPadding)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.size(14.dp),
                                painter = painterResource(id = R.drawable.ic_airplane),
                                contentDescription = null,
                                tint = White.copy(alpha = 0.6F)
                            )

                            Text(
                                modifier = Modifier.padding(start = Dimensions.HorizontalPadding),
                                text = "Your location",
                                color = White.copy(alpha = 0.6F),
                                fontSize = 14.sp
                            )
                        }
                        Row(
                            modifier = Modifier.padding(top = Dimensions.VerticalPadding),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                modifier = Modifier.padding(start = Dimensions.HorizontalPadding),
                                text = "Wertheimer, Illinois",
                                color = White,
                                fontSize = 18.sp
                            )
                            Icon(
                                modifier = Modifier.padding(top = Padding4),
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                tint = White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1F))
                    Icon(
                        modifier = Modifier
                            .background(color = White, shape = CircleShape)
                            .padding(8.dp)
                            .size(24.dp),
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = null,
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BackButton(isSearching, onToggleSearch)

                SearchRow(
                    isSearching = isSearching,
                    toggleSearch = { onToggleSearch() },
                    findOrder = { orderId -> onSearchOrder(orderId) }
                )
            }
        }
    }
}
