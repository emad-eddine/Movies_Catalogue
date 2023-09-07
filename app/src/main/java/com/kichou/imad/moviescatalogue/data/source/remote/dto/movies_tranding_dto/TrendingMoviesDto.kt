package com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_tranding_dto


import com.google.gson.annotations.SerializedName
import com.kichou.imad.moviescatalogue.domain.model.TrendingMovies

data class TrendingMoviesDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)


fun TrendingMoviesDto.toTrendingMovies() : List<TrendingMovies>{
    return results.map {
        TrendingMovies(
            movieId = it.id,
            movieTitle = it.title,
            moviePosterPath = it.posterPath
        )
    }.toList()
}