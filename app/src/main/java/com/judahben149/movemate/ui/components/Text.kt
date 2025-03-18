package com.judahben149.movemate.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun LabelText(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    fontWeight: FontWeight = FontWeight.Bold,
    textColor: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        modifier = modifier.padding(paddingValues),
        text = stringResource(textId),
        fontSize = 18.sp,
        fontWeight = fontWeight,
        color = textColor
    )
}

@Composable
fun SecondaryText(
    text: String,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    alignment: TextAlign? = null,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
) {
    Text(
        modifier = modifier.padding(paddingValues),
        text = text,
        color = Color.Gray,
        fontSize = fontSize,
        textAlign = alignment,
        fontWeight = fontWeight,
        maxLines = maxLines,
        overflow = overflow
    )
}