package com.kichou.imad.moviescatalogue.di

import android.content.Context
import com.kichou.imad.moviescatalogue.common.Constants
import com.kichou.imad.moviescatalogue.data.repository.MovieDetailRepositoryImp
import com.kichou.imad.moviescatalogue.data.repository.MoviesGenreRepositoryImp
import com.kichou.imad.moviescatalogue.data.repository.TrendingMoviesRepositoryImp
import com.kichou.imad.moviescatalogue.data.source.remote.TmdbApi
import com.kichou.imad.moviescatalogue.domain.repository.MovieDetailRepository
import com.kichou.imad.moviescatalogue.domain.repository.MoviesGenreRepository
import com.kichou.imad.moviescatalogue.domain.repository.TrendingMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideTmdbApi() : TmdbApi{

        return Retrofit
            .Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbApi::class.java)

    }


    @Provides
    @Singleton
    fun provideMoviesGenreRepository(tmdbApi: TmdbApi , @ApplicationContext context: Context) : MoviesGenreRepository{
        return MoviesGenreRepositoryImp(tmdbApi,context)
    }

    @Provides
    @Singleton
    fun provideTrendingMoviesRepository(tmdbApi: TmdbApi , @ApplicationContext context: Context) : TrendingMoviesRepository{
        return TrendingMoviesRepositoryImp(tmdbApi,context)
    }

    @Provides
    @Singleton
    fun provideMovieDetailRepository(tmdbApi: TmdbApi , @ApplicationContext context: Context) : MovieDetailRepository{
        return MovieDetailRepositoryImp(tmdbApi,context)
    }

}