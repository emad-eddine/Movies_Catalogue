package com.kichou.imad.moviescatalogue.domain.model

import com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto.Genre
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto.Result

data class MovieDetail(
    val movieId: Int,

    val movieName: String,

    val movieReleasedDate: String,

    val movieGenre: List<Genre>,

    val movieDescription: String,

    val movieRunTimeInMinutes: String,

    val moviePosterPath: String,

    val movieMpaaRating: String ?= null


)
