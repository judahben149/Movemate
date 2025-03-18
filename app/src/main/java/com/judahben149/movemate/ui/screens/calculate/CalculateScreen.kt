package com.judahben149.movemate.ui.screens.calculate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.judahben149.movemate.R
import com.judahben149.movemate.ui.components.ActionButton
import com.judahben149.movemate.ui.components.LabelText
import com.judahben149.movemate.ui.components.Screen

@Composable
fun CalculateScreenRoute(
    onNavigateBack: () -> Unit,
    onCalculateClicked: () -> Unit
) {
    CalculateScreen(
        onNavigateBack = onNavigateBack,
        onCalculateClicked = onCalculateClicked
    )
}

@Composable
fun CalculateScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onCalculateClicked: () -> Unit
) {

    Screen {
        Column {
            CalculateTopAppBar(onNavigateBack)

            LazyColumn(
                contentPadding = PaddingValues(vertical = 24.dp, horizontal = 24.dp),
            ) {
                item {
                    LabelText(
                        textId = R.string.destination,
                    )
                }

                item { DestinationCard() }
                item { PackagingCard() }
                item { CategoriesComponent() }

                item {
                    ActionButton(
                        onButtonClick = onCalculateClicked,
                        label = R.string.calculate,
                        paddingValues = PaddingValues(top = 48.dp),
                        labelFontSize = 22.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CalculateScreenPreview() {
    CalculateScreen(modifier = Modifier, {}, {})
}