package com.judahben149.movemate.utils

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

@Composable
fun SetSystemBarsColors(
    statusBarColor: Color,
    navigationBarColor: Color,
    darkIcons: Boolean = !isSystemInDarkTheme()
) {
    val window = (LocalContext.current as? Activity)?.window
    
    DisposableEffect(statusBarColor, navigationBarColor, darkIcons) {
        window?.apply {
            this.statusBarColor = statusBarColor.toArgb()
            this.navigationBarColor = navigationBarColor.toArgb()
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                var flags = decorView.systemUiVisibility

                flags = if (darkIcons) {
                    flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                }
                decorView.systemUiVisibility = flags
            }
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                var flags = decorView.systemUiVisibility
                flags = if (darkIcons) {
                    flags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                } else {
                    flags and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
                }
                decorView.systemUiVisibility = flags
            }
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                insetsController?.apply {
                    setSystemBarsAppearance(
                        if (darkIcons) WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS else 0,
                        WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                    )
                    setSystemBarsAppearance(
                        if (darkIcons) WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS else 0,
                        WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
                    )
                }
            }
        }
        
        onDispose {}
    }
}