package com.kichou.imad.moviescatalogue.presentation.navigation

sealed class Screens(val route : String){

    object splashScreen : Screens("splash_screen")

    object mainScreen : Screens("main_screen")

    object movieDetailScreen : Screens("movie_detail_screen")

}
