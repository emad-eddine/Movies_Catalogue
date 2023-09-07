package com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
