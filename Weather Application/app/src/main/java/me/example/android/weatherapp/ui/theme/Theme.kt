package me.example.android.weatherapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

@Composable
fun OpenWeatherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

val dimensions: Dimensions
    @Composable
    @ReadOnlyComposable
    get() {
        val sw = LocalConfiguration.current.smallestScreenWidthDp
        return when {
            sw <= 360 -> LocalSw360dpDimensions.current
            sw <= 480 -> LocalSw480dpDimensions.current
            else -> LocalLargeDimensions.current
        }
    }

val orientation: Int
    @Composable
    @ReadOnlyComposable
    get() = LocalConfiguration.current.orientation