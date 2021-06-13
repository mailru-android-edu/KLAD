package com.example.finema.ui.movieDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finema.api.IMoviesRepository
import com.example.finema.database.DatabaseRepository
import com.example.finema.database.firebase.IFirebaseRepository
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.databaseModels.TopModel
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.models.movieResponse.MovieTrailer
import com.example.finema.repositories.IAppPreference
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val repository: IMoviesRepository,
    private val dbRepository: DatabaseRepository,
    private val fbRepository: IFirebaseRepository,
    private val appPreference: IAppPreference
) : BaseViewModel() {

    var film = MutableLiveData<MovieDetails>()
    var trailer = MutableLiveData<MovieTrailer>()
    var arg: Long = 0
    var favouriteMovies: LiveData<List<Long>> = dbRepository.checkFavourite(listOf(arg))

    fun getMovieDetails() {
        job = Coroutines.ioThenMan(
            { repository.getMovieDetails(arg) },
            {
                film.value = it
                film.value!!.stringGenres = ""
                film.value!!.stringCompanies = ""

                for (item in it!!.genres) {
                    film.value!!.stringGenres += item.name + NEW_LINE
                }

                for (item in it.productionCompanies) {
                    film.value!!.stringCompanies += item.name + TAB + item.originCountry + NEW_LINE
                }

                Log.d("gypsy", "Details")
            }
        )
    }

    fun getTrailer() {
        job = Coroutines.ioThenMan(
            { repository.getTrailers(arg) },
            {
                val smt = it?.trailers
                Log.d("gypsy", "SMT " + smt?.size.toString())
                smt?.forEach { item ->
                    if (item.site == "YouTube" && item.type == "Trailer") {
                        trailer.value = item
                        Log.d("gypsy", "TrailerYES")
                    }
                }
            }
        )
        job.start()
    }

    fun insert(movieModel: MovieModel) {
        viewModelScope.launch(Dispatchers.Main) {
            dbRepository.insertFavourite(movieModel) {
            }
        }
        if (appPreference.getGuestOrAuth() == "AUTH") {
            viewModelScope.launch(Dispatchers.Main) {
                fbRepository.insertFirebaseFavouriteFilm(movieModel)
            }
        }
    }

    fun checkFavourite() {
        favouriteMovies = dbRepository.checkFavourite(listOf(arg))
    }

    fun toTopModel(movieModel: MovieModel): TopModel {
        return TopModel(
            movieModel.id,
            movieModel.title,
            movieModel.imageUrl,
            movieModel.about,
            movieModel.genres,
            movieModel.rating,
            movieModel.companies
        )
    }

    fun deleteMovie(id: Long, movie: MovieModel) {
        viewModelScope.launch(Dispatchers.Main) {
            dbRepository.deleteFavouriteMovie(id) {}
        }
        if (appPreference.getGuestOrAuth() == "AUTH") {
            viewModelScope.launch(Dispatchers.Main) {
                fbRepository.deleteFirebaseFavouriteFilm(movie)
            }
        }
    }

    suspend fun addToTopMovies(movieModel: TopModel) {
        dbRepository.insertTop(movieModel) {}
    }

    fun getFragment(): String? {
        return appPreference.getFragment()
    }

    companion object {
        const val NEW_LINE = "\n"
        const val TAB = "\t"
    }
}
