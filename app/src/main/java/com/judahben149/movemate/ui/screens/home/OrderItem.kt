package com.judahben149.movemate.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.R
import com.judahben149.movemate.domain.model.Order
import com.judahben149.movemate.ui.components.SecondaryText

@Composable
fun OrderItem(order: Order) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(40.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape)
                .padding(6.dp),
            painter = painterResource(id = R.drawable.box),
            contentDescription = null,
            tint = Color.White
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = order.name,
                fontWeight = Bold,
                fontSize = 18.sp
            )

            Spacer(Modifier.height(2.dp))
            
            Row(verticalAlignment = CenterVertically) {
                SecondaryText(
                    text = order.id,
                    fontSize = 16.sp
                )

                SecondaryText(
                    text = "•",
                    fontSize = 20.sp,
                    paddingValues = PaddingValues(horizontal = 4.dp)
                )

                SecondaryText(text = order.sender, fontSize = 14.sp)

                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .padding(horizontal = 2.dp),
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color.Gray
                )

                SecondaryText(
                    text = order.receiver,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun OrderRowPreview() {
    OrderItem(
        Order(
            id = "#NE43857340857904",
            name = "Macbook pro M2",
            sender = "Paris",
            receiver = "Morocco"
        )
    )
}