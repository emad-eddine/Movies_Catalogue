package com.kichou.imad.moviescatalogue.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kichou.imad.moviescatalogue.BuildConfig
import com.kichou.imad.moviescatalogue.presentation.navigation.AppNavigation
import com.kichou.imad.moviescatalogue.presentation.ui.theme.MoviesCatalogueTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesCatalogueTheme {
                AppNavigation()

            }
        }
    }
}
