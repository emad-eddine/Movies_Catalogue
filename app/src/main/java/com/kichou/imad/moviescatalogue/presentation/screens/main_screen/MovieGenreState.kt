package com.kichou.imad.moviescatalogue.presentation.screens.main_screen

import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.MoviesGenreDto

data class MovieGenreState(

    val isLoading : Boolean = false,

    val genres : MoviesGenreDto?= null,

    val error : String ?= null


)
