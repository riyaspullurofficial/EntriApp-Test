package com.riyas.entriapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.riyas.entriapp.adapters.paging.MoviePagingSource

class HomeFragmentViewModel:ViewModel() {

    val listData= Pager(PagingConfig(pageSize = 1)){
      MoviePagingSource()
    }.flow.cachedIn(viewModelScope)

}