package com.judahben149.movemate.ui.screens.shipment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.R
import com.judahben149.movemate.domain.enums.ShipmentStatus
import com.judahben149.movemate.domain.model.Shipment
import com.judahben149.movemate.ui.animation.AnimationDefaults
import com.judahben149.movemate.ui.components.StatusPill

@Composable
fun ShipmentItemCard(
    shipment: Shipment,
    primaryColour: Color = MaterialTheme.colorScheme.primary,
    outlineColour: Color = MaterialTheme.colorScheme.outline
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
    ) {
        Row(
            modifier = Modifier
                .padding(top = 12.dp, start = 16.dp, end = 16.dp)
                .background(
                    color = Color.White.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(3F)
            ) {

                StatusPill(status = shipment.status)

                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = stringResource(id = R.string.arriving_today),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = stringResource(
                        id = R.string.delivery_info,
                        shipment.id,
                        shipment.sender
                    ),
                    fontSize = 14.sp,
                    color = Color.Gray,
                    lineHeight = 16.sp
                )

                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = shipment.amount,
                        color = primaryColour,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "•",
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                    )

                    Text(
                        text = shipment.date,
                        fontSize = 14.sp,
                    )
                }
            }
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .weight(1F),
                painter = painterResource(id = R.drawable.ic_packaging_box_filled),
                contentDescription = null,
                tint = outlineColour,
            )
        }
    }
}

@Preview
@Composable
fun ShipmentCardPreview() {
    val shipment = Shipment(
        id = "NEJ20089934122231",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.InProgress,
        amount = "$1400 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    )

    ShipmentItemCard(shipment = shipment)
}
