package com.kichou.imad.moviescatalogue.domain.repository

import com.kichou.imad.moviescatalogue.BuildConfig
import com.kichou.imad.moviescatalogue.common.Constants
import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.MoviesGenreDto
import kotlinx.coroutines.flow.Flow

interface MoviesGenreRepository {


    suspend fun getMoviesGenre(
        queryParameters: Map<String, String> = mapOf(
            "language" to Constants.ENGLISH,
            "api_key" to BuildConfig.TMDB_API_KEY
        )
    ) : Flow<Resource<MoviesGenreDto>>




}

