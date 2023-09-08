package com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("release_dates")
    val releaseDates: List<ReleaseDate>
)