package com.example.finema.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/finema/api/MoviesRepository;", "Lcom/example/finema/api/IMoviesRepository;", "Lcom/example/finema/repositories/SafeApiRequest;", "api", "Lcom/example/finema/api/MoviesApi;", "dao", "Lcom/example/finema/database/room/RoomDao;", "context", "Landroid/content/Context;", "(Lcom/example/finema/api/MoviesApi;Lcom/example/finema/database/room/RoomDao;Landroid/content/Context;)V", "getGenres", "Lcom/example/finema/models/GenreRequest/GenreList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieDetails", "Lcom/example/finema/models/movieResponse/MovieDetails;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovies", "Lcom/example/finema/models/movieResponse/MovieResponse;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesWithGenre", "with_genres", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MoviesRepository extends com.example.finema.repositories.SafeApiRequest implements com.example.finema.api.IMoviesRepository {
    private final com.example.finema.api.MoviesApi api = null;
    private final com.example.finema.database.room.RoomDao dao = null;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMovies(int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.movieResponse.MovieResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getGenres(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.GenreRequest.GenreList> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMoviesWithGenre(int page, @org.jetbrains.annotations.NotNull()
    java.lang.String with_genres, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.movieResponse.MovieResponse> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMovieDetails(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.movieResponse.MovieDetails> p1) {
        return null;
    }
    
    public MoviesRepository(@org.jetbrains.annotations.NotNull()
    com.example.finema.api.MoviesApi api, @org.jetbrains.annotations.NotNull()
    com.example.finema.database.room.RoomDao dao, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}