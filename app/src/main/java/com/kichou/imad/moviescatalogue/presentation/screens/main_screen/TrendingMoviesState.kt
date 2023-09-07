package com.kichou.imad.moviescatalogue.presentation.screens.main_screen

import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.MoviesGenreDto
import com.kichou.imad.moviescatalogue.domain.model.TrendingMovies

data class TrendingMoviesState (

    val isLoading : Boolean = false,

    val trendingMovies : List<TrendingMovies> ?= null,

    val error : String ?= null

)