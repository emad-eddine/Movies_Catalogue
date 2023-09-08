package com.kichou.imad.moviescatalogue.presentation.screens.movie_detail_screen

import com.kichou.imad.moviescatalogue.domain.model.MovieDetail

data class MovieDetailState(

    val loading : Boolean = false,

    val data : MovieDetail ?= null,

    val message : String ?= null


)
