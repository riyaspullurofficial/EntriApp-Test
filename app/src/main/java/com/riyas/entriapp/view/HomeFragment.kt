package com.riyas.entriapp.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.riyas.entriapp.adapters.recyclerview.MovieRecyclerAdapter
import com.riyas.entriapp.databinding.FragmentHomeBinding
import com.riyas.entriapp.viewmodel.HomeFragmentViewModel
import kotlinx.coroutines.launch

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding
    lateinit var mAdapter:MovieRecyclerAdapter
    lateinit var mViewModel: HomeFragmentViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding=FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel= ViewModelProvider(this).get(HomeFragmentViewModel::class.java)


      try {

          if (internetConnectionCheck(requireContext())){
              initRecycler()
              loadingData()


          }else{
              Toast.makeText(context,"Check Internet",Toast.LENGTH_SHORT).show()
          }
      }catch (e:Exception){
          Log.d("eeee",e.message.toString())
      }
    }

    private fun loadingData() {
       lifecycleScope.launch {
           mViewModel.listData.collect{pagingData->
               mAdapter.submitData(pagingData)


           }
       }
    }

    private fun initRecycler() {
        mAdapter= MovieRecyclerAdapter()
        binding.recyclerRvId.apply {
            layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            adapter= mAdapter
            setHasFixedSize(true)
        }

    }
  /*  private fun insertData(){
        lifecycleScope.launch {

          mRoomViewModel.insertData(MovieModelRoom( MovieRecyclerAdapter.itemData!!.id,
              MovieRecyclerAdapter.itemData!!.original_language, MovieRecyclerAdapter.itemData!!.original_title,
              MovieRecyclerAdapter.itemData!!.overview, MovieRecyclerAdapter.itemData!!.poster_path,
              MovieRecyclerAdapter.itemData!!.release_date, MovieRecyclerAdapter.itemData!!.title))
        }
    }*/


    private fun internetConnectionCheck(context: Context):Boolean{

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                                   as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }
}