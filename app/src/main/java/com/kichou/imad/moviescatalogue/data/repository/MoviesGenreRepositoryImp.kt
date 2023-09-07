package com.kichou.imad.moviescatalogue.data.repository

import android.content.Context
import com.kichou.imad.moviescatalogue.R
import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.data.source.remote.TmdbApi
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_genre_dto.MoviesGenreDto
import com.kichou.imad.moviescatalogue.domain.repository.MoviesGenreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class MoviesGenreRepositoryImp @Inject constructor(
    private val tmdbApi: TmdbApi,
    private val context: Context) : MoviesGenreRepository{
    override suspend fun getMoviesGenre(
        queryParameters: Map<String, String>
    ): Flow<Resource<MoviesGenreDto>> = flow {



        try {
            emit(Resource.Loading())
            val result = tmdbApi.getMoviesGenre(queryParameters)

            emit(Resource.Success(data = result))


        }catch(e: HttpException) {
            emit(Resource.Error(
                message = e.localizedMessage ?: context.getString(R.string.error)

            ))
        } catch(e: IOException) {
            emit(Resource.Error(
                message = e.localizedMessage ?: context.getString(R.string.connection_error)
            ))
        }

    }
}