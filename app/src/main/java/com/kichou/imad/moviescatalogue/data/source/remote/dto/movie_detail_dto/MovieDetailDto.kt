package com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto


import com.google.gson.annotations.SerializedName
import com.kichou.imad.moviescatalogue.domain.model.MovieDetail

data class MovieDetailDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("release_dates")
    val releaseDates: ReleaseDates,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    val status: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)


fun MovieDetailDto.toMovieDetail() : MovieDetail{


    val movieRating = releaseDates.results.filter {
        it.iso31661 == "US"
    }.filter {result ->
        result.releaseDates.any {releaseDate ->
            releaseDate.certification != ""
        }
    }

    // calculate run time

    val runTimeInHours = "${(runtime / 60).toInt().toString()}h ${runtime%60}m"

    return MovieDetail(
        movieId = id,
        movieName = originalTitle,
        movieDescription = overview,
        movieGenre = genres,
        moviePosterPath = posterPath,
        movieReleasedDate = releaseDate.substring(0,4),
        movieRunTimeInMinutes = runTimeInHours,
        movieMpaaRating = if(movieRating.size !=0){
            movieRating.get(0).releaseDates.get(0).certification
        }else{
            null
        }
    )





}