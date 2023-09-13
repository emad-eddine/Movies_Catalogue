package com.kichou.imad.moviescatalogue.data.source.remote

import com.kichou.imad.moviescatalogue.domain.model.MovieDetail
import com.kichou.imad.moviescatalogue.domain.model.MovieDetailFireBase
import kotlinx.coroutines.flow.Flow

interface FireBaseDataBase {


    suspend fun getMovieDetails() : List<MovieDetailFireBase>


    suspend fun addMovie(movieDetailFireBase: MovieDetailFireBase)


    suspend fun editMovie(movieDetailFireBase: MovieDetailFireBase)


    suspend fun deleteMovie(movieDetailFireBase: MovieDetailFireBase)



}