package com.riyas.entriapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.riyas.entriapp.models.moviemodelapi.ResultMovie
@Database(entities = [ResultMovie::class], version = 1)
abstract class MovieDatabase :RoomDatabase()  {
    abstract val movieDaoInMovieDb:MovieDao

    companion object{

        @Volatile
        private var INSTANCE:MovieDatabase?=null

        fun getInstance(context: Context):MovieDatabase{
            synchronized(this){
                var instance= INSTANCE
                if (instance==null){
                    instance=Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "Movie_database_db"
                    ).build()
                }
                return instance
            }
        }

    }
}