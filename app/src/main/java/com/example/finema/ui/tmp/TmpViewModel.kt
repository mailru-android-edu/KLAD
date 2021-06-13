package com.example.finema.ui.tmp

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.finema.database.DatabaseRepository
import com.example.finema.database.firebase.IFirebaseRepository
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.repositories.IAppPreference
import com.example.finema.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TmpViewModel(
    private val dbRepository: DatabaseRepository,
    private val fbRepository: IFirebaseRepository,
    private val appPreference: IAppPreference
) : BaseViewModel() {

    private val allMovies = fbRepository.allMovies

    private lateinit var observerList: Observer<List<MovieModel>>

    init {
        fbRepository.initRefs()
    }

    fun initRoomFromFirebaseToRoom() {
        observerList = Observer { listMovie ->
            listMovie.map { it.id = it.idFirebase.toLong() }
            for (item in listMovie) {
                viewModelScope.launch(Dispatchers.Main) {
                    dbRepository.insertFavourite(item) {}
                }
            }
        }
        allMovies.observeForever {
            observerList
        }
    }

    fun getFirstSignIn(): Boolean {
        return appPreference.getFirstSignIn()
    }

    fun getGuestOrAuth(): String? {
        return appPreference.getGuestOrAuth()
    }

    fun setFirstSignIn(boolean: Boolean) {
        appPreference.setFirstSignIn(boolean)
    }

    fun setTournamentType(string: String) {
        appPreference.setTournamentType(string)
    }

    fun insertFavourite(item: MovieModel) {
        viewModelScope.launch(Dispatchers.Main) {
            dbRepository.insertFavourite(item) {}
        }
    }

    override fun onCleared() {
        allMovies.removeObserver(observerList)
        super.onCleared()
    }
}
