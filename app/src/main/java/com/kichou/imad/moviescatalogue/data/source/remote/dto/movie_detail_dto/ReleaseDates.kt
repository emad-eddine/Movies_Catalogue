package com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto


import com.google.gson.annotations.SerializedName

data class ReleaseDates(
    @SerializedName("results")
    val results: List<Result>
)