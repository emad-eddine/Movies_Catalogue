package com.kichou.imad.moviescatalogue.presentation.screens.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kichou.imad.moviescatalogue.BuildConfig
import com.kichou.imad.moviescatalogue.common.Constants
import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.domain.use_cases.get_movies_genre_use_case.GetMoviesGenreUseCase
import com.kichou.imad.moviescatalogue.domain.use_cases.get_trending_movies_use_case.GetTrendingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getMoviesGenreUseCase: GetMoviesGenreUseCase,
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase) : ViewModel(){


        private val _moviesGenreState = mutableStateOf(MovieGenreState())

        val genreState : State<MovieGenreState> = _moviesGenreState


        private val _trendingMoviesState = mutableStateOf(TrendingMoviesState())

        val trendingMoviesState : State<TrendingMoviesState> = _trendingMoviesState


        init {

            viewModelScope.launch {
                getMoviesGenreList(mapOf(
                    "language" to Constants.ENGLISH,
                    "api_key" to BuildConfig.TMDB_API_KEY
                ))

                getTrendingMoviesList(mapOf(
                    "language" to Constants.ENGLISH,
                    "api_key" to BuildConfig.TMDB_API_KEY
                ))
            }

        }

        private suspend fun getMoviesGenreList(queryParameters: Map<String, String> = mapOf(
            "language" to Constants.ENGLISH,
            "api_key" to BuildConfig.TMDB_API_KEY
        )) {


            getMoviesGenreUseCase(queryParameters).onEach { result ->

                when(result){

                    is Resource.Success ->{
                        _moviesGenreState.value = MovieGenreState(genres = result.data)
                    }

                    is Resource.Error -> {
                        _moviesGenreState.value = MovieGenreState(
                            error = result.message)
                    }

                    is Resource.Loading ->{

                        _moviesGenreState.value = MovieGenreState(isLoading = true)

                    }



                }


            }.launchIn(viewModelScope)


        }


        private suspend fun getTrendingMoviesList(queryParameters: Map<String, String> = mapOf(
            "language" to Constants.ENGLISH,
            "api_key" to BuildConfig.TMDB_API_KEY
        )){

            getTrendingMoviesUseCase.invoke(queryParameters).onEach {result ->

                when(result){

                    is Resource.Success ->{
                        _trendingMoviesState.value = TrendingMoviesState(trendingMovies = result.data)
                    }

                    is Resource.Error -> {
                        _trendingMoviesState.value = TrendingMoviesState(
                            error = result.message)
                    }

                    is Resource.Loading ->{

                        _trendingMoviesState.value = TrendingMoviesState(isLoading = true)

                    }



                }






            }.launchIn(viewModelScope)

        }





}