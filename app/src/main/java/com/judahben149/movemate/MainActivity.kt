package com.judahben149.movemate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.judahben149.movemate.ui.navigation.MoveMateNavigation
import com.judahben149.movemate.ui.theme.MovemateTheme
import com.judahben149.movemate.ui.theme.PrimaryColor
import com.judahben149.movemate.utils.SetSystemBarsColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()

        setContent {
            SetSystemBarsColors(
                statusBarColor = PrimaryColor,
                navigationBarColor = PrimaryColor
            )

            MovemateTheme {
                MoveMateNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovemateTheme {
        MoveMateNavigation()
    }
}