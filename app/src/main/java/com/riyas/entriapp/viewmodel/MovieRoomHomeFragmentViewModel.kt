package com.riyas.entriapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.riyas.entriapp.models.moviemodelroom.MovieModelRoom
import com.riyas.entriapp.repository.MovieRoomRepository
import kotlinx.coroutines.launch

class MovieRoomHomeFragmentViewModel (private val repository: MovieRoomRepository): ViewModel() {
    val movies=repository.products



    fun insertData(movieModelRoom: MovieModelRoom) =viewModelScope.launch {
        repository.insert(movieModelRoom)
    }
}