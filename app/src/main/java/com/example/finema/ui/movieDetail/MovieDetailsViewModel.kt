package com.example.finema.ui.movieDetail

import androidx.lifecycle.MutableLiveData
import com.example.finema.api.MoviesApi
import com.example.finema.models.MovieDetails
import com.example.finema.models.MovieResponse
import com.example.finema.newapi.MoviesRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Job

class MovieDetailsViewModel(
) : BaseViewModel()  {

    private val api = MoviesApi()
    private val repository = MoviesRepository(api)


    private lateinit var job: Job

    var film = MutableLiveData<MovieDetails>()


    fun getMovieDetails(id: Long) {
        job = Coroutines.ioThenMain1(
            { repository.getMovieDetails(id) },
            { film.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}