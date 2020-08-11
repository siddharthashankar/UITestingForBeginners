package com.sid.uitest.recyclerviewui.data

import com.sid.uitest.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?

    fun getMovies(): List<Movie>
}