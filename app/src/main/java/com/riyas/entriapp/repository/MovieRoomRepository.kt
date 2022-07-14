package com.riyas.entriapp.repository

import com.riyas.entriapp.models.moviemodelroom.MovieModelRoom
import com.riyas.entriapp.room.MovieDao

class MovieRoomRepository (private val dao: MovieDao) {
    val products = dao.getAllMovies()


    suspend fun insert(product: MovieModelRoom) {
        dao.insertDataDao(product)
    }
}