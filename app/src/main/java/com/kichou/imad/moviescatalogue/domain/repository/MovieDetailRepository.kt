package com.kichou.imad.moviescatalogue.domain.repository

import com.kichou.imad.moviescatalogue.BuildConfig
import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto.MovieDetailDto
import com.kichou.imad.moviescatalogue.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MovieDetailRepository {


    suspend fun getMovieDetailsById(

       movieId : Int,

        queryParameters: Map<String, String> = mapOf(
            "append_to_response" to "release_dates",
            "api_key" to BuildConfig.TMDB_API_KEY
        )
    ) : Flow<Resource<MovieDetail>>


}