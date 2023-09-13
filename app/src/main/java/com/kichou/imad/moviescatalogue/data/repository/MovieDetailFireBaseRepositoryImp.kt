package com.kichou.imad.moviescatalogue.data.repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.kichou.imad.moviescatalogue.common.Resource
import com.kichou.imad.moviescatalogue.domain.model.MovieDetailFireBase
import com.kichou.imad.moviescatalogue.domain.model.MovieTo
import com.kichou.imad.moviescatalogue.domain.repository.MovieDetailFirebaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailFireBaseRepositoryImp @Inject constructor(

    private val fireBaseRef : DatabaseReference

) : MovieDetailFirebaseRepository{
    override suspend fun getMovieDetails(): Flow<Resource<List<MovieDetailFireBase>>> = flow {

        try {

            emit(Resource.Loading())

            val postListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // Get Post object and use the values to update the UI
                    val post = dataSnapshot.getValue<String>()
                    // ...
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message

                }
            }
            fireBaseRef.addValueEventListener(postListener)



        }catch (e : Exception){
            emit(Resource.Error(message = e.message))
        }




    }

    override suspend fun addMovie(movieDetailFireBase: MovieDetailFireBase) {

        try {

            fireBaseRef.child("Movies").child(movieDetailFireBase.movieId).child("movie_name").setValue(movieDetailFireBase.movieName)
            fireBaseRef.child("Movies").child(movieDetailFireBase.movieId).child("movie_title").setValue(movieDetailFireBase.movieTitle)
        }catch (e : Exception){
            e.printStackTrace()
        }



    }

    override suspend fun editMovie(movieDetailFireBase: MovieDetailFireBase) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMovie(movieDetailFireBase: MovieDetailFireBase) {
        TODO("Not yet implemented")
    }
}