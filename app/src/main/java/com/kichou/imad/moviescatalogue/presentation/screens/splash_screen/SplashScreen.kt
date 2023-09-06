package com.kichou.imad.moviescatalogue.presentation.screens.splash_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kichou.imad.moviescatalogue.R
import com.kichou.imad.moviescatalogue.presentation.navigation.Screens
import com.kichou.imad.moviescatalogue.presentation.ui.theme.DarkYellow


@Composable
fun SplashScreen(
    navController: NavController) {

    var progress by remember {
        mutableStateOf(0.1f)
    }

    val progressAnimation = animateFloatAsState(
        targetValue = progress,
        label = "",
        animationSpec = tween(
            durationMillis = 2000,
            delayMillis = 50)){

        navController.navigate(route = Screens.mainScreen.route){
            popUpTo(Screens.splashScreen.route){
                inclusive = true
            }
        }

    }


    LaunchedEffect(key1 = progress){
        progress = 1f
    }


    Box (modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center){

        CircularProgressIndicator(

            progress = progressAnimation.value,
            color = DarkYellow,
            strokeWidth = 3.dp,
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.Center)
        )


        Image(
            painter = painterResource(id = R.drawable.movies_catalogue_ic),
            contentDescription = "movie_catalogue_icon",
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp))

    }



}