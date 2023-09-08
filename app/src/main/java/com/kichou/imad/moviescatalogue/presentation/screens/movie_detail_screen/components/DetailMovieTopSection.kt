package com.kichou.imad.moviescatalogue.presentation.screens.movie_detail_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import coil.compose.SubcomposeAsyncImage
import com.kichou.imad.moviescatalogue.common.Constants
import com.kichou.imad.moviescatalogue.presentation.ui.theme.Purple
import com.kichou.imad.moviescatalogue.presentation.ui.theme.Roboto
import com.kichou.imad.moviescatalogue.presentation.ui.theme.WhiteText


@Composable
fun DetailMovieTopSection(
    modifier: Modifier = Modifier,
    movieName : String,
    moviePosterPath : String,
    movieReleaseDate : String,
    onBackBtnClicked : () -> Unit = {},
    onFavBtnClicked : () -> Unit = {}) {


    Box (modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(0.5f)){

        SubcomposeAsyncImage(
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize(),
                    strokeWidth = 2.dp,
                    color = Color.LightGray
                )
            },
            model = Constants.API_IMAGES_BASE_URL + moviePosterPath,
            contentDescription = movieName,
            modifier = Modifier
                .fillMaxSize()
                .align(alignment = Alignment.Center),
            contentScale = ContentScale.FillBounds
        )

        // Black gradient overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                        colors = listOf(Color.Transparent, MaterialTheme.colorScheme.primary),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )


        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "arrow_back",
            tint = Color.White,
            modifier = Modifier
                .fillMaxWidth(0.15f)
                .fillMaxHeight(0.15f)
                .align(Alignment.TopStart)
                .padding(top = 15.dp, start = 10.dp)
                .clickable {
                    onBackBtnClicked()
                })


        Icon(imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "like_btn",
            tint = Color.White,
            modifier = Modifier
                .fillMaxWidth(0.15f)
                .fillMaxHeight(0.15f)
                .align(Alignment.TopEnd)
                .padding(top = 15.dp, end = 10.dp)
                .clickable {
                    onFavBtnClicked()
                })


        Text(text = movieName,
            style = TextStyle(
                fontFamily = Roboto,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            ),
            color = WhiteText,
            overflow = TextOverflow.Clip,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(horizontal = 10.dp)
                .align(Alignment.BottomStart)
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Start
        )


        Surface (
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .align(Alignment.BottomEnd)
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(100.dp),
            color = Purple
        ){

            Text(text = movieReleaseDate,
                style = TextStyle(
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = WhiteText
                ),
                modifier = Modifier
                    .padding(10.dp),
                textAlign = TextAlign.End
            )

        }




    }

}