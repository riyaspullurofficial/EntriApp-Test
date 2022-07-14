package com.riyas.entriapp.models.moviemodelroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_details")
data class MovieModelRoom(
    @PrimaryKey
    @ColumnInfo(name="id")
    val id: Int,
    @ColumnInfo(name="language")
    val original_language: String,
    @ColumnInfo(name="originaltitle")
    val original_title: String,
    @ColumnInfo(name="overview")
    val overview: String,
    @ColumnInfo(name="poster")
    val poster_path: String,
    @ColumnInfo(name="releasedate")
    val release_date: String,
    @ColumnInfo(name="title")
    val title: String,
)
