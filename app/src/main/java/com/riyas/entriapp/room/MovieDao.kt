package com.riyas.entriapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.riyas.entriapp.models.moviemodelapi.ResultMovie

@Dao
interface MovieDao {

    @Insert
    suspend fun insertDataDao(resultMovie: List<ResultMovie>)

    @Query("SELECT * FROM movietable ")
    fun getAllMovies(): List<ResultMovie>



/*    fun getAllMovies(): LiveData<List<ResultMovie>>*/
}