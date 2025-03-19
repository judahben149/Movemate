package com.judahben149.movemate.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.layoutId
import com.judahben149.movemate.R
import com.judahben149.movemate.ui.animation.AnimationDefaults
import com.judahben149.movemate.ui.theme.White

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material3.MaterialTheme

@OptIn(ExperimentalMotionApi::class)
@Composable
fun TopAppBarWithMotion(
    isSearching: Boolean,
    onToggleSearch: () -> Unit,
    onSearchOrder: (String) -> Unit,
) {
    var animateComponents by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val softKeyboard = LocalSoftwareKeyboardController.current

    val progress by animateFloatAsState(
        targetValue = if (isSearching) 1f else 0f,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
        label = "Top App Bar Animation_Motion Layout"
    )

    fun clearFocus() {
        focusManager.clearFocus()
        softKeyboard?.hide()
    }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    AnimatedVisibility(
        visible = animateComponents,
        enter = slideInVertically(
            animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION_500),
            initialOffsetY = { fullHeight -> -fullHeight }
        ),
    ) {
        MotionLayout(
            modifier = Modifier
                .background(Color(0xFF543b9b))
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .clipToBounds(),
            motionScene = MotionScene(
                content = """
                    {
                      ConstraintSets: {
                        normal: {
                          profile_image: {
                            width: 48,
                            height: 48,
                            start: ['parent', 'start', 16],
                            top: ['parent', 'top', 16],
                            alpha: 1.0,
                            scaleX: 1.0,
                            scaleY: 1.0
                          },
                          location_column: {
                            width: 'spread',
                            height: 'wrap',
                            start: ['profile_image', 'end', 16],
                            top: ['profile_image', 'top', 0],
                            bottom: ['profile_image', 'bottom', 0],
                            alpha: 1.0,
                            scaleX: 1.0,
                            scaleY: 1.0
                          },
                          notification_icon: {
                            width: 40,
                            height: 40,
                            end: ['parent', 'end', 16],
                            top: ['profile_image', 'top', 0],
                            bottom: ['profile_image', 'bottom', 0],
                            alpha: 1.0,
                            scaleX: 1.0,
                            scaleY: 1.0
                          },
                          search_container: {
                            width: 'spread',
                            height: "wrap",
                            start: ['parent', 'start', 16],
                            end: ['parent', 'end', 16],
                            top: ['profile_image', 'bottom', 24]
                          },
                          back_button: {
                            width: 40,
                            height: 40,
                            start: ['parent', 'start', -80],
                            top: ['search_container', 'top', 32],
                            bottom: ['search_container', 'bottom', 0],
                            alpha: 0.0
                          },
                          search_row: {
                            width: 'spread',
                            height: 'wrap',
                            start: ['parent', 'start', 16],
                            end: ['parent', 'end', 16],
                            top: ['search_container', 'top', 0],
                          }
                        },
                        searching: {
                          profile_image: {
                            width: 48,
                            height: 48,
                            start: ['parent', 'start', 16],
                            top: ['parent', 'top', -80],
                            alpha: 0.0,
                            scaleX: 1.1,
                            scaleY: 1.1
                          },
                          location_column: {
                            width: 'spread',
                            height: 'wrap',
                            start: ['profile_image', 'end', 16],
                            top: ['profile_image', 'top', 0],
                            bottom: ['profile_image', 'bottom', 0],
                            alpha: 0.0,
                            scaleX: 1.1,
                            scaleY: 1.1
                          },
                          notification_icon: {
                            width: 40,
                            height: 40,
                            end: ['parent', 'end', 16],
                            top: ['profile_image', 'top', 0],
                            bottom: ['profile_image', 'bottom', 0],
                            alpha: 0.0,
                            scaleX: 1.1,
                            scaleY: 1.1
                          },
                          search_container: {
                            width: 'spread',
                            height: "wrap",
                            start: ['parent', 'start', 0],
                            end: ['parent', 'end', 0],
                            top: ['parent', 'top', 16]
                          },
                          back_button: {
                            width: 56,
                            height: 56,
                            start: ['parent', 'start', 0],
                            top: ['parent', 'top', 24],
                            alpha: 1.0
                          },
                          search_row: {
                            width: 'spread',
                            height: 'wrap',
                            start: ['back_button', 'end', 8],
                            end: ['parent', 'end', 16],
                            top: ['search_container', 'top', 0],
                          }
                        }
                      },
                      Transitions: {
                        default: {
                          from: 'normal',
                          to: 'searching',
                          duration: 600,
                          interpolator: 'fastOutSlowIn'
                        }
                      }
                    }
                """.trimIndent()
            ),
            progress = progress
        ) {
            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.ic_profile_picture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .layoutId("profile_image")
                    .clip(CircleShape)
            )

            // Location Column
            Column(
                modifier = Modifier.layoutId("location_column")
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
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Your location",
                        color = White.copy(alpha = 0.6F),
                        fontSize = 14.sp
                    )
                }

                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Wertheimer, Illinois",
                        color = White,
                        fontSize = 18.sp
                    )

                    Icon(
                        modifier = Modifier.padding(top = 4.dp),
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = White
                    )
                }
            }

            // Notification Icon
            Icon(
                modifier = Modifier
                    .layoutId("notification_icon")
                    .background(color = White, shape = CircleShape)
                    .padding(8.dp),
                imageVector = Icons.Outlined.Notifications,
                contentDescription = null,
            )

            // Search Container
            Box(modifier = Modifier.layoutId("search_container"))

            // Back Button
                Icon(
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .size(48.dp)
                        .layoutId("back_button")
                        .clickable { onToggleSearch() },
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
                )

            // Search Row
            Row(
                modifier = Modifier
                    .layoutId("search_row")
                    .clip(RoundedCornerShape(38.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color(0xFF543b9b),
                    modifier = Modifier.padding(8.dp)
                )

                BasicTextField(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                        onSearchOrder(it)
                    },
                    textStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
                    decorationBox = { innerTextField ->
                        if (searchText.isEmpty()) {
                            Text(
                                text = "Enter the receipt number...",
                                color = Color.Gray.copy(alpha = 0.6f),
                                fontSize = 16.sp
                            )
                        }
                        innerTextField()
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .focusRequester(focusRequester)
                        .onFocusChanged {
                            if (it.isFocused && !isSearching) {
                                onToggleSearch()
                            }
                        }
                        .onGloballyPositioned {
                            if (isSearching) {
                                focusRequester.requestFocus()
                            } else {
                                clearFocus()
                                searchText = ""
                            }
                        }
                )

                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFF37022))
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_barcode),
                        contentDescription = "Scan",
                        tint = White
                    )
                }
            }
        }
    }
}