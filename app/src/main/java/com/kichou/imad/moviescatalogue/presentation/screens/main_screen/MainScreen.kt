package com.kichou.imad.moviescatalogue.presentation.screens.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kichou.imad.moviescatalogue.R
import com.kichou.imad.moviescatalogue.presentation.screens.main_screen.components.CategoriesSection
import com.kichou.imad.moviescatalogue.presentation.screens.main_screen.components.SearchBar
import com.kichou.imad.moviescatalogue.presentation.screens.main_screen.components.TopSection
import com.kichou.imad.moviescatalogue.presentation.screens.main_screen.components.TrendingMoviesSection
import com.kichou.imad.moviescatalogue.presentation.ui.theme.DarkYellow
import com.kichou.imad.moviescatalogue.presentation.ui.theme.Roboto
import com.kichou.imad.moviescatalogue.presentation.ui.theme.WhiteText


@Composable
fun MainScreen(
  mainScreenViewModel: MainScreenViewModel = hiltViewModel()) {


    val scrolState = rememberScrollState()

    val moviesGenreState = mainScreenViewModel.genreState.value

    val trendingMoviesState = mainScreenViewModel.trendingMoviesState.value


    Column (modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)
        .verticalScroll(scrolState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start){

        TopSection()

        Spacer(modifier = Modifier.height(16.dp))

        SearchBar(){
            // to do search function
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.categories),
            style = TextStyle(
                fontFamily = Roboto,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            color = WhiteText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(10.dp))


        if(moviesGenreState.isLoading){
            CircularProgressIndicator()
        }
        else{
            if(moviesGenreState.genres!=null){
                CategoriesSection(moviesGenreDto = moviesGenreState.genres)
            }
            else if(moviesGenreState.error?.isNotEmpty() == true){
                Text(text = moviesGenreState.error,
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.Center)
            }
        }


        // movies list section

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically){

            Text(
                text = stringResource(id = R.string.trending),
                style = TextStyle(
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                color = WhiteText,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.8f)
                    .padding(horizontal = 10.dp),
                textAlign = TextAlign.Start
            )

            Text(
                text = stringResource(id = R.string.see_all),
                style = TextStyle(
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,

                ),
                color = DarkYellow,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
                    .padding(horizontal = 10.dp)
                    .clickable {

                    },
                textAlign = TextAlign.End,
                textDecoration = TextDecoration.Underline
            )


        }


        if(trendingMoviesState.isLoading){
            CircularProgressIndicator()
        }
        else{
            if(trendingMoviesState.trendingMovies!=null){
                TrendingMoviesSection(trendingMovies = trendingMoviesState.trendingMovies)
            }
            else if(trendingMoviesState.error?.isNotEmpty() == true){
                Text(text = trendingMoviesState.error,
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.Center)
            }
        }




    }

}