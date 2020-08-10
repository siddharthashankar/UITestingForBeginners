package com.sid.uitest.factory


import androidx.fragment.app.FragmentFactory
import com.sid.uitest.movieapp.ui.DirectorsFragment
import com.sid.uitest.movieapp.ui.MovieDetailFragment
import com.sid.uitest.movieapp.ui.StarActorsFragment

class MovieFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
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













