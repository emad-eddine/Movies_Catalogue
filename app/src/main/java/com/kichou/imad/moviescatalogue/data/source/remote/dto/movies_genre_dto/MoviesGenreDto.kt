package com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto


import com.google.gson.annotations.SerializedName

data class MoviesGenreDto(
    @SerializedName("genres")
    val genres: List<Genre>
)

