package com.kichou.imad.moviescatalogue.presentation.screens.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.Genre
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.MoviesGenreDto
import com.kichou.imad.moviescatalogue.presentation.ui.theme.Roboto


@Composable
fun CategoriesSection(
    modifier : Modifier = Modifier,
    moviesGenreDto: MoviesGenreDto
) {


    LazyRow (modifier = modifier
        .fillMaxWidth()
        .padding(10.dp)){

        items(moviesGenreDto.genres.size){

            CategorieItem(moviesGenreDto.genres[it])

        }

    }



}


@Composable
fun CategorieItem(
    movieGenre : Genre
) {

    Box (modifier = Modifier
        .padding(5.dp)
        .background(MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(100.dp))){

        Text(
            text = movieGenre.name,
            style = TextStyle(
                fontFamily = Roboto,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color =MaterialTheme.colorScheme.secondary
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )


    }


}