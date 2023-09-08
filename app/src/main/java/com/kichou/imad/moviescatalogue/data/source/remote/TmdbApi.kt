package com.kichou.imad.moviescatalogue.data.source.remote

import com.kichou.imad.moviescatalogue.BuildConfig
import com.kichou.imad.moviescatalogue.common.Constants
import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto.MovieDetailDto
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.MoviesGenreDto
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_tranding_dto.TrendingMoviesDto
import com.kichou.imad.moviescatalogue.domain.model.TrendingMovies
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface TmdbApi {


    @GET("3/genre/movie/list")
    suspend fun getMoviesGenre(
        @QueryMap queryParameters: Map<String, String> = mapOf(
            "language" to Constants.ENGLISH,
            "api_key" to BuildConfig.TMDB_API_KEY
        )
    ) : MoviesGenreDto


    @GET("3/trending/movie/week")
    suspend fun getTrendingMovies(

        @QueryMap queryParameters: Map<String, String> = mapOf(
            "language" to Constants.ENGLISH,
            "api_key" to BuildConfig.TMDB_API_KEY
        )

    ) : TrendingMoviesDto



    @GET("3/movie/{movieId}")
    suspend fun getMovieDetailsById(

        @Path("movieId") movieId : Int,

        @QueryMap queryParameters: Map<String, String> = mapOf(
            "append_to_response" to "release_dates",
            "api_key" to BuildConfig.TMDB_API_KEY
        )
    ) : MovieDetailDto



}
