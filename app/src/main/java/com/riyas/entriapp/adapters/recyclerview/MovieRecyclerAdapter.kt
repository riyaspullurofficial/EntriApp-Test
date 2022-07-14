package com.riyas.entriapp.adapters.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.riyas.entriapp.adapters.paging.MoviePagingSource
import com.riyas.entriapp.databinding.MovieCardShowBinding
import com.riyas.entriapp.models.moviemodelapi.ResultMovie
import com.riyas.entriapp.util.Constants

class MovieRecyclerAdapter : PagingDataAdapter<ResultMovie, MovieRecyclerAdapter.MyViewHolder>(diffUtils) {
   private var pageNo=MoviePagingSource.pageRoom
    inner class MyViewHolder (val binding:MovieCardShowBinding): RecyclerView.ViewHolder(binding.root)
    companion object{
        var itemData:ResultMovie?=null

        val diffUtils=object :DiffUtil.ItemCallback<ResultMovie>(){
            override fun areItemsTheSame(oldItem: ResultMovie, newItem: ResultMovie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultMovie, newItem: ResultMovie): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item =getItem(position)

            holder.binding.apply {
                cardTitleID.text=item?.title
                languageCardID.text=item?.original_language
                releaseDateID.text=item?.release_date
                descriptionCardID.text=item?.overview
                val imageLink=Constants.BASE_URL_IMAGE+item?.poster_path
                imageCardID.load(imageLink)

                if (pageNo==1){
                    itemData=item

                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(MovieCardShowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

}
