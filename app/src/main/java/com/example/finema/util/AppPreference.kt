package com.example.finema.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

//TODO Сделать репозиторием с интерфейсом
object AppPreference {

    private const val INIT_USER = "initUser"
    private const val INIT_GENRES = "initGenres"
    private const val NAME_PREF = "preference"
    private const val NUM_FILMS = "numFilms"
    private const val TOURNAMENT_TYPE = "tournamentType"
    private const val GENRE_ID = "genre_id"
    private const val CATEGORY_LINK = "category_link"

    private val googleUser: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var mPreferences: SharedPreferences

    //TODO такого не должно быть, преференсы должны исполььзоваться только здесь
    fun getPreference(context: Context): SharedPreferences {
        mPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreferences
    }

    fun setInitUser(init: Boolean) {
        mPreferences.edit()
            .putBoolean(INIT_USER, init)
            .apply()
    }

    fun getInitUser(): Boolean {
        return mPreferences.getBoolean(INIT_USER, false)
    }

    fun getGeneratedGenres(): Boolean {
        return mPreferences.getBoolean(INIT_GENRES, false)
    }

    fun setGeneratedGenres(init: Boolean) {
        mPreferences.edit()
            .putBoolean(INIT_GENRES, init)
            .apply()
    }

    fun googleUserSignOut() {
        googleUser.signOut()
        Log.d("OJOF", googleUser.currentUser?.displayName.orEmpty())
    }

    fun getNumOfFilms(): Int {
        return mPreferences.getInt(NUM_FILMS, 8)
    }

    fun setNumOfFilms(num: Int) {
        mPreferences.edit()
            .putInt(NUM_FILMS, num)
            .apply()
    }

    fun getTournamentType(): String? {
        return mPreferences.getString(TOURNAMENT_TYPE, "")
    }

    fun setTournamentType(type: String) {
        mPreferences.edit()
            .putString(TOURNAMENT_TYPE, type)
            .apply()
    }

    fun getGenre(): String? {
        return mPreferences.getString(GENRE_ID, "")
    }

    fun setGenre(genre: String) {
        mPreferences.edit()
            .putString(GENRE_ID, genre)
            .apply()
    }

    fun getCategoryLink(): Int? {
        return mPreferences.getInt(CATEGORY_LINK, -1)
    }

    fun setCategoryLink(categoryLink: Int) {
        mPreferences.edit()
            .putInt(CATEGORY_LINK, categoryLink)
            .apply()
    }



}