package com.kichou.imad.moviescatalogue.presentation.screens.movie_detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto.Genre
import com.kichou.imad.moviescatalogue.presentation.ui.theme.Roboto
import com.kichou.imad.moviescatalogue.presentation.ui.theme.WhiteText


@Composable
fun MoviesDetailSection(
    movieRating : String,
    genre: List<Genre>,
    movieDuration : String,
    modifier : Modifier = Modifier) {



    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)) {

        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically){


            Box (contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .border(2.dp, Color.White, RoundedCornerShape(20))){

                Text(text = movieRating,
                    style = TextStyle(
                        fontFamily = Roboto,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = WhiteText
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )

            }

            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight(0.8f),
                color = Color.White
            )

            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)){


                items(genre.size -1){

                    GenreItem(genre[it],isLastItem = false)

                }

                item {

                    GenreItem(genre[genre.size-1],isLastItem = true)

                }

            }
        }





    }




}

@Composable
fun GenreItem(
    genre : Genre,
    isLastItem : Boolean = false) {

    Row (modifier = Modifier
        .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically){

        Text(text = genre.name,
            style = TextStyle(
                fontFamily = Roboto,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = WhiteText
            )
        )

        if (!isLastItem){
            Divider(
                modifier = Modifier
                    .fillMaxHeight(0.6f)
                    .width(1.dp),
                color = Color.White
            )
        }



    }

}