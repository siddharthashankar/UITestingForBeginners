package com.sid.uitest.espressoidlingresource.ui.movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.espressouitestexamples.data.source.MoviesDataSource
import com.codingwithmitch.espressouitestexamples.data.source.MoviesRemoteDataSource
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory
import com.sid.uitest.R
import com.sid.uitest.espressoidlingresource.ui.UICommunicationListener
import kotlinx.android.synthetic.main.activity_espresso_idling_resource.*

import kotlinx.android.synthetic.main.activity_main.*

class EspressoIdlingResourceActivity : AppCompatActivity(),
    UICommunicationListener
{

    override fun loading(isLoading: Boolean) {
        if (isLoading)
            progress_bar.visibility = View.VISIBLE
        else
            progress_bar.visibility = View.INVISIBLE
    }

    // dependencies (typically would be injected with dagger)
    lateinit var requestOptions: RequestOptions
    lateinit var moviesDataSource: MoviesDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = MovieFragmentFactory(
            requestOptions,
            moviesDataSource
            )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_espresso_idling_resource)

        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieListFragment::class.java, null)
                .commit()
        }
    }

    private fun initDependencies(){
        if(!::requestOptions.isInitialized){
            // glide
            requestOptions = RequestOptions
                .placeholderOf(R.drawable.default_image)
                .error(R.drawable.default_image)
        }
        if(!::moviesDataSource.isInitialized){
            // Data Source
            moviesDataSource = MoviesRemoteDataSource()
        }
    }



}







