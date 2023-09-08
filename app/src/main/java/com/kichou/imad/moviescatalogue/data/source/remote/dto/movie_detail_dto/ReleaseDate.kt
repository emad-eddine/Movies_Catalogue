package com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto


import com.google.gson.annotations.SerializedName

data class ReleaseDate(
    @SerializedName("certification")
    val certification: String,
    @SerializedName("descriptors")
    val descriptors: List<String>,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("note")
    val note: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("type")
    val type: Int
)