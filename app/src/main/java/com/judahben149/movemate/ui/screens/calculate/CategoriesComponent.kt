package com.judahben149.movemate.ui.screens.calculate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.domain.model.Category
import com.judahben149.movemate.R
import com.judahben149.movemate.ui.animation.AnimationDefaults
import com.judahben149.movemate.ui.animation.bounce
import com.judahben149.movemate.ui.components.basic.LabelText
import com.judahben149.movemate.ui.components.basic.SecondaryText
import com.judahben149.movemate.ui.theme.CursorNavyBlue

@Composable
fun CategoriesComponent() {
    val categories = listOf(
        Category("Documents"),
        Category("Glass"),
        Category("Liquid"),
        Category("Food"),
        Category("Electronic"),
        Category("Product"),
        Category("Others"),
    )
    var animateComponents by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    AnimatedVisibility(
        visible = animateComponents,
        enter = slideInVertically(
            animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION_500),
            initialOffsetY = { fullHeight -> fullHeight * 2 })
                + fadeIn(animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION_500)),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            LabelText(
                textId = R.string.categories,
            )

            SecondaryText(
                text = stringResource(id = R.string.what_are_you_sending),
                modifier = Modifier.padding(top = 6.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            CategoryChips(categories)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryChips(
    categories: List<Category>
) {
    var animateComponents by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        maxItemsInEachRow = 4
    ) {
        categories.forEach {
            AnimatedVisibility(
                visible = animateComponents,
                enter = slideInHorizontally(
                    animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION_500),
                    initialOffsetX = { fullWidth -> fullWidth * 4 })
                        + fadeIn(animationSpec = tween(AnimationDefaults.TWEEN_ANIMATION_DURATION_500)),
            ) { CategoryChip(category = it) }
        }
    }
}

@Composable
fun CategoryChip(category: Category) {
    var selected by remember { mutableStateOf(category.isSelected) }

    FilterChip(
        modifier = Modifier.padding(end = 8.dp).bounce(),
        onClick = { selected = !selected },
        label = {
            Text(
                text = category.name,
                modifier = Modifier.padding(vertical = 8.dp),
                color = if (selected) {
                    Color.White
                } else {
                    if (isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        CursorNavyBlue
                    }
                },
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color.White
                )
            }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = CursorNavyBlue,
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderWidth = 1.5.dp,
            borderColor = Color.Gray.copy(alpha = 0.7F),
            enabled = true,
            selected = selected
        )
    )
}

@Preview(widthDp = 500, heightDp = 500, backgroundColor = 0xFFFDE6D4)
@Composable
fun CategoriesComponentPreview() {
    CategoriesComponent()
}
