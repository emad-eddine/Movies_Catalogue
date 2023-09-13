package com.kichou.imad.moviescatalogue.domain.repository

import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.domain.model.MovieDetailFireBase
import kotlinx.coroutines.flow.Flow

interface MovieDetailFirebaseRepository {




    suspend fun getMovieDetails() : Flow<Resource<List<MovieDetailFireBase>>>


    suspend fun addMovie(movieDetailFireBase: MovieDetailFireBase)


    suspend fun editMovie(movieDetailFireBase: MovieDetailFireBase)


    suspend fun deleteMovie(movieDetailFireBase: MovieDetailFireBase)



}