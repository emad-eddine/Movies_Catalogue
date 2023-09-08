package com.kichou.imad.moviescatalogue.presentation.screens.movie_detail_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kichou.imad.moviescatalogue.R
import com.kichou.imad.moviescatalogue.presentation.screens.movie_detail_screen.components.DetailMovieTopSection
import com.kichou.imad.moviescatalogue.presentation.screens.movie_detail_screen.components.MoviesDetailSection
import com.kichou.imad.moviescatalogue.presentation.ui.theme.DarkYellow
import com.kichou.imad.moviescatalogue.presentation.ui.theme.Roboto
import com.kichou.imad.moviescatalogue.presentation.ui.theme.WhiteText


@Composable
fun MovieDetailScreen(

    movieDetailViewModel: MovieDetailViewModel = hiltViewModel(),
    navController: NavHostController
) {


    val movieDetailState = movieDetailViewModel.movieDetailState.value

    val scrollState = rememberScrollState()

    var textHasOverflow by remember {
        mutableStateOf(false)
    }

    var topSectionHeight by remember {
        mutableStateOf(0.7f)
    }

    var isUpIconClicked by remember {
        mutableStateOf(false)
    }
    
    val animateState = animateFloatAsState(
        targetValue = if (isUpIconClicked) 0.4f else 0.7f,
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 0
        ),
        label = ""
    )
    


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            ,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start){

        if(!movieDetailState.loading && movieDetailState.data != null){
            DetailMovieTopSection(
                movieName = movieDetailState.data.movieName,
                moviePosterPath = movieDetailState.data.moviePosterPath,
                movieReleaseDate = movieDetailState.data.movieReleasedDate,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(animateState.value),
                onBackBtnClicked = {
                    navController.popBackStack()
                }
            )

            MoviesDetailSection(
                movieRating = movieDetailState.data.movieMpaaRating ?: "",
                genre = movieDetailState.data.movieGenre,
                movieDuration = movieDetailState.data.movieRunTimeInMinutes,
                modifier = Modifier
                    .fillMaxHeight(0.15f)
                    .padding(start = 10.dp)
            )

            Text(text = movieDetailState.data.movieRunTimeInMinutes,
                style = TextStyle(
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = WhiteText
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp)
            )

            Text(text = stringResource(id = R.string.overview),
                style = TextStyle(
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = WhiteText
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp)
            )

            Text(text = movieDetailState.data.movieDescription,
                style = TextStyle(
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    color = WhiteText
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
                    .verticalScroll(scrollState),
                overflow = if(isUpIconClicked) TextOverflow.Clip else TextOverflow.Ellipsis,
                maxLines = if(isUpIconClicked) Int.MAX_VALUE else 2,
                onTextLayout = {
                    textHasOverflow = it.hasVisualOverflow
                }
            )

            if(textHasOverflow){
                Icon(imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "up_arrow",
                    tint = DarkYellow,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 10.dp)
                        .clickable {
                            isUpIconClicked = true
                        })
            }

            if(isUpIconClicked){
                Icon(imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "down_arrow",
                    tint = DarkYellow,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 10.dp)
                        .clickable {
                            isUpIconClicked = false
                        })
            }



        }

    }



}