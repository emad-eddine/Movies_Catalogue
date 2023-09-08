package com.kichou.imad.moviescatalogue.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kichou.imad.moviescatalogue.presentation.screens.main_screen.MainScreen
import com.kichou.imad.moviescatalogue.presentation.screens.movie_detail_screen.MovieDetailScreen
import com.kichou.imad.moviescatalogue.presentation.screens.splash_screen.SplashScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.splashScreen.route ){

        composable(route = Screens.splashScreen.route){
            SplashScreen(navController)
        }

        composable(route = Screens.mainScreen.route){

            MainScreen(navController = navController)

        }

        composable(route = Screens.movieDetailScreen.route + "/{movieId}"){
            MovieDetailScreen(navController = navController)
        }

    }
}