package com.kichou.imad.moviescatalogue.data.repository

import android.content.Context
import com.kichou.imad.moviescatalogue.R
import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.data.source.remote.TmdbApi
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_tranding_dto.TrendingMoviesDto
import com.kichou.imad.moviescatalogue.data.source.remote.dto.movies_tranding_dto.toTrendingMovies
import com.kichou.imad.moviescatalogue.domain.model.TrendingMovies
import com.kichou.imad.moviescatalogue.domain.repository.TrendingMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class TrendingMoviesRepositoryImp @Inject constructor(
    private val tmdbApi: TmdbApi,
    private val context : Context) : TrendingMoviesRepository {



    override suspend fun getTrendingMovies(
        queryParameters: Map<String, String>): Flow<Resource<List<TrendingMovies>>> = flow {


            try
            {

                emit(Resource.Loading())
                val result = tmdbApi.getTrendingMovies(queryParameters)

                emit(Resource.Success(data = result.toTrendingMovies()))


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