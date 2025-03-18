package com.judahben149.movemate.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.R
import com.judahben149.movemate.domain.model.Shipment
import com.judahben149.movemate.ui.animation.AnimationDefaults
import com.judahben149.movemate.ui.theme.Dimensions
import com.judahben149.movemate.ui.theme.ReceiverBoxLightGreen
import com.judahben149.movemate.ui.theme.SenderBoxLightOrange
import com.judahben149.movemate.ui.theme.TextLightOrange
import com.judahben149.movemate.ui.theme.TrackerIndicatorGreen
import com.judahben149.movemate.utils.extension.friendlyText

@Composable
fun TrackingCard(
    currentShipment: Shipment
) {
    var animateComponents by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    AnimatedVisibility(
        visible = animateComponents,
        enter = slideInVertically(
            animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION),
            initialOffsetY = { fullHeight -> fullHeight * 2 })
                + fadeIn(animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION)),
    ) {
        Column {
            LabelText(
                textId = R.string.tracking,
                paddingValues = PaddingValues(
                    top = Dimensions.Padding24,
                    start = Dimensions.Padding16
                )
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimensions.Padding16)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(Dimensions.Padding16)
                    )
                    .padding(vertical = 12.dp)
                    .clip(RoundedCornerShape(Dimensions.Padding16)),
            ) {
                Row(modifier = Modifier.padding(horizontal = Dimensions.Padding16)) {
                    Column {
                        Text(
                            text = stringResource(R.string.shipment_number),
                            color = Color.Gray,
                            fontSize = 16.sp
                        )

                        Text(
                            modifier = Modifier.padding(top = Dimensions.Padding4),
                            text = currentShipment.id,
                            fontSize = 18.sp,
                            fontWeight = Bold
                        )
                    }

                    Spacer(modifier = Modifier.weight(1F))

                    Image(
                        painter = painterResource(id = R.drawable.ic_forklift),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(Dimensions.ProfileIconSize)
                    )
                }

                AdjustableDivider(horizontalPadding = Dimensions.HorizontalPadding)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimensions.Padding24),
                    verticalAlignment = Bottom,
                    horizontalArrangement = SpaceBetween
                ) {
                    Column {
                        ShipmentInfoWidget(
                            title = stringResource(R.string.sender),
                            description = currentShipment.sender,
                            icon = R.drawable.box,
                            backgroundColor = SenderBoxLightOrange
                        )

                        Spacer(modifier = Modifier.height(32.dp))
                        ShipmentInfoWidget(
                            title = stringResource(R.string.receiver),
                            description = currentShipment.receiver,
                            icon = R.drawable.box,
                            backgroundColor = ReceiverBoxLightGreen
                        )
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                    Column(
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        ShipmentInfoWidget(
                            title = stringResource(R.string.time),
                            description = currentShipment.timeline,
                            showIcon = false,
                            showIndicator = true
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        ShipmentInfoWidget(
                            title = stringResource(R.string.status),
                            description = currentShipment.status.friendlyText(),
                            showIcon = false
                        )
                    }
                }

                HorizontalDivider(
                    modifier = Modifier.padding(
                        vertical = Dimensions.VerticalPadding,
                    ),
                    color = Color.Gray.copy(alpha = 0.2F)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = TextLightOrange
                    )
                    Text(
                        text = "Add Stop",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontWeight = Bold
                    )
                }
            }
        }
    }
}

@Composable
fun ShipmentInfoWidget(
    title: String,
    description: String,
    icon: Int = 0,
    backgroundColor: Color = White,
    showIcon: Boolean = true,
    showIndicator: Boolean = false
) {
    Row {
        if (showIcon) {
            Image(
                modifier = Modifier
                    .background(color = backgroundColor, shape = CircleShape)
                    .size(48.dp)
                    .padding(Dimensions.Padding4),
                painter = painterResource(id = icon),
                contentDescription = null,
            )
        }

        Column(
            modifier = Modifier.padding(start = Dimensions.Padding8),
        ) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onTertiary,
                fontSize = 14.sp
            )

            Row(verticalAlignment = CenterVertically) {
                if (showIndicator) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_circle),
                        contentDescription = null,
                        modifier = Modifier
                            .size(Dimensions.Padding16)
                            .padding(end = Dimensions.Padding4),
                        tint = TrackerIndicatorGreen
                    )
                }

                Text(
                    text = description,
                    fontSize = 16.sp,
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onBackground,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}
