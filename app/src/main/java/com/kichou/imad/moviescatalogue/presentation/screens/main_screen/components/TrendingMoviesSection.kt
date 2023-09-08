package com.kichou.imad.moviescatalogue.presentation.screens.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.kichou.imad.moviescatalogue.common.Constants
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.Genre
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.MoviesGenreDto
import com.kichou.imad.moviescatalogue.domain.model.TrendingMovies
import com.kichou.imad.moviescatalogue.presentation.ui.theme.Roboto
import com.kichou.imad.moviescatalogue.presentation.ui.theme.WhiteText


@Composable
fun TrendingMoviesSection(modifier : Modifier = Modifier,
                          trendingMovies: List<TrendingMovies>,
                          onClick: (String) -> Unit
) {


    LazyRow (modifier = modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(0.dp)){

        items(
            if(trendingMovies.size>11){
                11
            }
            else{
                trendingMovies.size
            }
        ){

            TrendingMovieItem(trendingMovies[it]){movieId->
                onClick(movieId)
            }

        }

    }




}


@Composable
fun TrendingMovieItem(
    trendingMovies: TrendingMovies,
    onClick : (String) -> Unit
) {

    Column (modifier = Modifier
        .padding(6.dp)
        .clickable {
                   onClick(trendingMovies.movieId.toString())
        },
        verticalArrangement = Arrangement.Center){


        SubcomposeAsyncImage(
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(50.dp),
                    strokeWidth = 2.dp,
                    color = Color.LightGray
                )
            },
            model = Constants.API_IMAGES_BASE_URL + trendingMovies.moviePosterPath,
            contentDescription = trendingMovies.movieTitle,
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .clip(shape = RoundedCornerShape(20.dp)),
            contentScale = ContentScale.FillBounds
        )



        Text(
            text = trendingMovies.movieTitle,
            style = TextStyle(
                fontFamily = Roboto,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = WhiteText
            ),
            textAlign = TextAlign.Start,
            modifier = Modifier
                .width(150.dp)
                .padding(horizontal = 10.dp, vertical = 10.dp),
            overflow = TextOverflow.Ellipsis
        )


    }


}