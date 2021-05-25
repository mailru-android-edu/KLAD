package com.example.finema.api

import android.content.Context
import androidx.paging.*
import com.example.finema.database.room.RoomDao
import com.example.finema.repositories.SafeApiRequest
import com.example.finema.ui.chooseFavourite.MoviePagingSource
import kotlinx.coroutines.flow.Flow
import java.util.*

class MoviesRepository(
    val api: MoviesApi,
    private val dao: RoomDao,
    private val context: Context
) : IMoviesRepository, SafeApiRequest() {

    override suspend fun getMovies(page: Int) = apiRequest {
        api.getMovies(page)
    }

    override suspend fun getGenres() = apiRequest {
        api.getGenreList()
    }

    //TODO запрос (20) -> liveData.value = response , local list add(response)
    //TODO запрос (20) -> local list add(response), liveData.value = list
    //TODO reducer почитать
    override suspend fun getMoviesWithGenre(page: Int, with_genres: String) = apiRequest {
        api.getMoviesWithGenre(page, with_genres)
    }

    override suspend fun getMovieDetails(id: Long) = apiRequest {
        api.getMovieDetails(id, Locale.getDefault().toString().replace('_', '-'))
    }

    override suspend fun getDiscoverMovies(query: String) =
        Pager(
            PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(api, query) }
        ).flow
}
