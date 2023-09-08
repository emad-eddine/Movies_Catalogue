package com.kichou.imad.moviescatalogue.domain.use_cases.get_movie_detail_use_case

import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.domain.model.MovieDetail
import com.kichou.imad.moviescatalogue.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository) {


    suspend operator fun invoke(movieId : Int) : Flow<Resource<MovieDetail>> {
        return movieDetailRepository.getMovieDetailsById(movieId = movieId)
    }


}