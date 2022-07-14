package com.riyas.entriapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.riyas.entriapp.models.moviemodelroom.MovieModelRoom

@Dao
interface MovieDao {

    @Insert
    suspend fun insertDataDao(product: MovieModelRoom)

    @Query("SELECT * FROM movie_details ")
    fun getAllMovies(): LiveData<List<MovieModelRoom>>


}