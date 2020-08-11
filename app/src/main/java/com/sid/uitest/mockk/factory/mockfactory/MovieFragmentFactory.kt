package com.sid.uitest.mockk.factory.mockfactory

import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.request.RequestOptions
import com.sid.uitest.data.source.MoviesDataSource
import com.sid.uitest.mockk.factory.MovieDetailFragment
import com.sid.uitest.movieapp.ui.DirectorsFragment
import com.sid.uitest.movieapp.ui.StarActorsFragment

class MovieFragmentFactory(
    private val requestOptions: RequestOptions? = null,
    private val moviesDataSource: MoviesDataSource? = null
) : FragmentFactory() {

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            MovieDetailFragment::class.java.name -> {
                if (requestOptions != null
                    && moviesDataSource != null
                ) {
                    MovieDetailFragment(
                        requestOptions,
                        moviesDataSource
                    )
                } else {
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

