package com.judahben149.movemate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.R
import com.judahben149.movemate.domain.enums.ShipmentStatus
import com.judahben149.movemate.ui.theme.OnSurfaceGrey
import com.judahben149.movemate.ui.theme.InProgressTextGreen
import com.judahben149.movemate.ui.theme.LoadingTextBlue
import com.judahben149.movemate.utils.extension.friendlyText

@Composable
fun StatusPill(status: ShipmentStatus) {

    val color = when (status) {
        ShipmentStatus.Completed -> Green
        ShipmentStatus.InProgress -> InProgressTextGreen
        ShipmentStatus.Pending -> MaterialTheme.colorScheme.secondary
        ShipmentStatus.Loading -> LoadingTextBlue
        ShipmentStatus.Cancelled -> Red
    }

    val icon = when (status) {
        ShipmentStatus.Completed -> R.drawable.ic_completed
        ShipmentStatus.InProgress -> R.drawable.in_progress
        ShipmentStatus.Pending -> R.drawable.ic_pending
        ShipmentStatus.Loading -> R.drawable.ic_loading
        ShipmentStatus.Cancelled -> R.drawable.ic_cancelled
    }
    Row(
        modifier = Modifier
            .background(
                color = OnSurfaceGrey.copy(alpha = 0.4F),
                shape = CircleShape
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = color
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = status.friendlyText(),
            fontSize = 14.sp,
            color = color,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview
@Composable
fun StatusPillPreview() {
    StatusPill(ShipmentStatus.InProgress)
}
