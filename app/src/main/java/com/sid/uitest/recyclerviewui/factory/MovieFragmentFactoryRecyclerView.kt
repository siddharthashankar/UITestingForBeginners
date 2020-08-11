package com.sid.uitest.recyclerviewui.factory

import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.request.RequestOptions
import com.sid.uitest.movieapp.ui.DirectorsFragment
import com.sid.uitest.movieapp.ui.StarActorsFragment
import com.sid.uitest.recyclerviewui.MovieDetailFragmentRecyclerView
import com.sid.uitest.recyclerviewui.MovieListFragment
import com.sid.uitest.recyclerviewui.data.MoviesDataSource

class MovieFragmentFactoryRecyclerView(
    private val requestOptions: RequestOptions? = null,
    private val moviesDataSource: MoviesDataSource? = null
) : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MovieListFragment::class.java.name -> {
                if (moviesDataSource != null) {
                    MovieListFragment(moviesDataSource)
                } else {
                    super.instantiate(classLoader, className)
                }
            }

            MovieDetailFragmentRecyclerView::class.java.name -> {
                if(requestOptions != null
                    && moviesDataSource != null){
                    MovieDetailFragmentRecyclerView(
                        requestOptions,
                        moviesDataSource
                    )
                }
                else{
                    super.instantiate(classLoader, className)
                }
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }

}

