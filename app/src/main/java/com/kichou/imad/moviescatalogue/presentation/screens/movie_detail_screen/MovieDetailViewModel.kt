package com.kichou.imad.moviescatalogue.presentation.screens.movie_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.domain.model.MovieDetailFireBase
import com.kichou.imad.moviescatalogue.domain.use_cases.add_movie_firebase_use_case.AddMovieToFireBaseUseCase
import com.kichou.imad.moviescatalogue.domain.use_cases.get_movie_detail_use_case.GetMovieDetailUseCase
import com.kichou.imad.moviescatalogue.presentation.screens.main_screen.MovieGenreState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val addMovieToFireBaseUseCase: AddMovieToFireBaseUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){


    private val _movieDetailState = mutableStateOf(MovieDetailState())

    val movieDetailState : State<MovieDetailState> = _movieDetailState


    init {
        viewModelScope.launch {

            val movieId: String? = savedStateHandle.get<String>("movieId")

            try {
                if (movieId != null) {
                    movieId?.toInt()?.let { getMovieDetail(it) }
                }
            }catch (e : Exception){

            }




        }
    }

    private suspend fun getMovieDetail(movieId : Int){

        getMovieDetailUseCase(movieId).onEach {result->


            when(result){

                is Resource.Success ->{
                    _movieDetailState.value = MovieDetailState(data = result.data)
                }

                is Resource.Error -> {
                    _movieDetailState.value = MovieDetailState(
                        message = result.message)
                }

                is Resource.Loading ->{

                    _movieDetailState.value = MovieDetailState(loading = true )

                }

            }


        }.launchIn(viewModelScope)

    }


     suspend fun addMovieTofireBase(movieDetailFireBase: MovieDetailFireBase){


        addMovieToFireBaseUseCase(movieDetailFireBase)


    }




}