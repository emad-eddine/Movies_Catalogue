package com.kichou.imad.moviescatalogue.data.repository

import android.content.Context
import com.kichou.imad.moviescatalogue.R
import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.data.source.remote.TmdbApi
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto.MovieDetailDto
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movie_detail_dto.toMovieDetail
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_tranding_dto.toTrendingMovies
import com.kichou.imad.moviescatalogue.domain.model.MovieDetail
import com.kichou.imad.moviescatalogue.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class MovieDetailRepositoryImp @Inject constructor(
    private val tmdbApi: TmdbApi,
    private val context: Context) : MovieDetailRepository{
    override suspend fun getMovieDetailsById(
        movieId: Int,
        queryParameters: Map<String, String>
    ): Flow<Resource<MovieDetail>> = flow {

        try
        {

            emit(Resource.Loading())
            val result = tmdbApi.getMovieDetailsById(movieId = movieId)

            emit(Resource.Success(data = result.toMovieDetail()))


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