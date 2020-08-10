package com.sid.uitest.data.source

import com.sid.uitest.data.Movie


interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}