package com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)