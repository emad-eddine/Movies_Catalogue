package com.kichou.imad.moviescatalogue.domain.use_cases.get_trending_movies_use_case

import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.MoviesGenreDto
import com.kichou.imad.moviescatalogue.domain.model.TrendingMovies
import com.kichou.imad.moviescatalogue.domain.repository.TrendingMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val trendingMoviesRepository: TrendingMoviesRepository) {


    suspend operator fun invoke(queryParameters: Map<String, String>): Flow<Resource<List<TrendingMovies>>> {

        return trendingMoviesRepository.getTrendingMovies(queryParameters)

    }

}