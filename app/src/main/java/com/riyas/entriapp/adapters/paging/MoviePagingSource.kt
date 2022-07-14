package com.riyas.entriapp.adapters.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.riyas.entriapp.models.moviemodelapi.ResultMovie
import com.riyas.entriapp.network.ApiService
import com.riyas.entriapp.network.MovieInstance
import com.riyas.entriapp.util.Constants


class MoviePagingSource : PagingSource<Int, ResultMovie>() {
    companion object{
        lateinit var dataRoom:List<ResultMovie>
        var pageRoom: Int ?=null
    }
    val movieInstance= MovieInstance.getRetrofitInstance().create(ApiService::class.java)
    override fun getRefreshKey(state: PagingState<Int, ResultMovie>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultMovie> {
        return try {
            val currentPage=params.key ?: 1
            pageRoom=currentPage
            val response=movieInstance.getAllMovies(Constants.API_KEY,currentPage)
            val data=response.results ?: emptyList()
            dataRoom=data
            val responseData= mutableListOf<ResultMovie>()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage ==1) null else -1,
                nextKey = currentPage.plus(1)
            )


        }catch (e:Exception){
            LoadResult.Error(e)
        }

    }
}



















/*class MoviePagingSources(private val apiService: ApiService): PagingSource<Int, ResultRickeyMorty>() {
    override fun getRefreshKey(state: PagingState<Int, ResultRickeyMorty>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultRickeyMorty> {
        return try {
            val currentPaage=params.key ?: 1
            val response=apiService.getAllCharacters(currentPaage)
            val data=response.body()?.resultRickeyMorties ?: emptyList()
            val responseData = mutableListOf<ResultRickeyMorty>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPaage ==1) null else -1,
                nextKey = currentPaage.plus(1)
            )


        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}*/