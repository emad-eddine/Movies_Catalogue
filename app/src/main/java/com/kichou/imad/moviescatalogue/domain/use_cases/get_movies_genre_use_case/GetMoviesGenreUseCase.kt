package com.kichou.imad.moviescatalogue.domain.use_cases.get_movies_genre_use_case

import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.MoviesGenreDto
import com.kichou.imad.moviescatalogue.domain.repository.MoviesGenreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesGenreUseCase @Inject constructor(
    private val moviesGenreRepository: MoviesGenreRepository) {


    suspend operator fun invoke(queryParameters: Map<String, String>): Flow<Resource<MoviesGenreDto>>{

        return moviesGenreRepository.getMoviesGenre(queryParameters)

    }

}