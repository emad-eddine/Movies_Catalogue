package com.kichou.imad.moviescatalogue.domain.use_cases.add_movie_firebase_use_case

import com.kichou.imad.moviescatalogue.domain.model.MovieDetailFireBase
import com.kichou.imad.moviescatalogue.domain.repository.MovieDetailFirebaseRepository
import javax.inject.Inject

class AddMovieToFireBaseUseCase @Inject constructor(
    private val movieDetailFirebaseRepository: MovieDetailFirebaseRepository) {


    suspend operator fun invoke(movieDetailFireBase: MovieDetailFireBase){
        return movieDetailFirebaseRepository.addMovie(movieDetailFireBase)
    }



}