package com.riyas.entriapp.models.moviemodelapi

data class MovieList(
    val page: Int,
    val results: List<ResultMovie>,
    val total_pages: Int,
    val total_results: Int
)