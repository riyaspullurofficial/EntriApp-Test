package com.riyas.entriapp.network

import androidx.lifecycle.LiveData
import com.riyas.entriapp.models.moviemodelapi.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/discover/movie")
    suspend fun getAllMovies( @Query("api_key")api_key:String, @Query("page")page:Int ):MovieList


}
