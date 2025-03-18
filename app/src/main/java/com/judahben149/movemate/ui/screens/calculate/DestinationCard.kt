package com.judahben149.movemate.ui.screens.calculate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.judahben149.movemate.R
import com.judahben149.movemate.ui.theme.Dimensions

@Composable
fun DestinationCard() {
    Column(
        modifier = Modifier
            .padding(top = Dimensions.Padding16)
            .background(color = MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(16.dp))
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 24.dp)
    ) {
        DestinationItem(iconId = R.drawable.ic_outbox, placeholder = "Sender location")
        DestinationItem(iconId = R.drawable.ic_inbox, placeholder = "Receiver location")
        DestinationItem(iconId = R.drawable.ic_scale, placeholder = "Approx weight")
    }

}

@Preview
@Composable
fun DestinationCardPreview() {
    DestinationCard()
}