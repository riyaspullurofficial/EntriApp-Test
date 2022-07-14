package com.riyas.entriapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.riyas.entriapp.repository.MovieRoomRepository

class MovieRoomViewModelFactory  (private val repository: MovieRoomRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        if (modelClass.isAssignableFrom(MovieRoomHomeFragmentViewModel::class.java)){
            return MovieRoomHomeFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")

    }

}