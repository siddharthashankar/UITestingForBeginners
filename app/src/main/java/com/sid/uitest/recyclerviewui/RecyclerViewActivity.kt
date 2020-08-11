package com.sid.uitest.recyclerviewui

import androidx.appcompat.app.AppCompatActivity
import com.sid.uitest.R
import android.os.Bundle
import com.bumptech.glide.request.RequestOptions
import com.sid.uitest.recyclerviewui.data.MoviesDataSource
import com.sid.uitest.recyclerviewui.data.MoviesRemoteDataSourceRecyclerView
import com.sid.uitest.recyclerviewui.factory.MovieFragmentFactoryRecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    // dependencies (typically would be injected with dagger)
    lateinit var requestOptions: RequestOptions
    lateinit var moviesDataSource: MoviesDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = MovieFragmentFactoryRecyclerView(
            requestOptions,
            moviesDataSource
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

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
            moviesDataSource = MoviesRemoteDataSourceRecyclerView()
        }
    }

}