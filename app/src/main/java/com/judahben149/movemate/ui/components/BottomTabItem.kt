package com.judahben149.movemate.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.domain.model.BottomTab
import com.judahben149.movemate.ui.theme.SelectedBottomBarColor
import com.judahben149.movemate.ui.theme.UnSelectedBottomBarColor

@Composable
fun BottomTabItem(
    modifier: Modifier = Modifier,
    tab: BottomTab,
    isSelected: Boolean,
    onTabSelected: (BottomTab) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable {
                onTabSelected(tab)
            }
            .padding(top = 16.dp),
    ) {
        val color = if (isSelected) SelectedBottomBarColor else UnSelectedBottomBarColor

        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = tab.icon),
            contentDescription = null,
            tint = color
        )

        Spacer(modifier = Modifier.size(4.dp))

        Text(
            text = stringResource(id = tab.id),
            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Normal,
            fontSize = 14.sp,
            color = color,
        )
    }
}