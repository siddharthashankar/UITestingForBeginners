package com.sid.uitest.mockk.factory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.RequestOptions
import com.sid.uitest.R
import com.sid.uitest.data.source.MoviesDataSource
import com.sid.uitest.mockk.factory.mockfactory.MovieFragmentFactory
import kotlinx.android.synthetic.main.activity_main_movie.*

class MockMovieMainActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_main_movie)
        activityName.text = "MockMovieMainActivity"

        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            val movieId = 1
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieDetailFragment::class.java, bundle)
                .commit()
        }
    }

    private fun initDependencies(){

        // glide
        requestOptions = RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)

        // Data Source
        moviesDataSource = MoviesRemoteDataSource()
    }

}