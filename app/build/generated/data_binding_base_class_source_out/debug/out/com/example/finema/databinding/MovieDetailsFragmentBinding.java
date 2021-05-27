// Generated by data binding compiler. Do not edit!
package com.example.finema.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.finema.R;
import com.example.finema.models.movieResponse.MovieDetails;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class MovieDetailsFragmentBinding extends ViewDataBinding {
  @NonNull
  public final TextView aboutTitle;

  @NonNull
  public final CheckBox checkFavourite;

  @NonNull
  public final TextView companies;

  @NonNull
  public final TextView companiesTitle;

  @NonNull
  public final TextView filmTitle;

  @NonNull
  public final TextView genreTitle;

  @NonNull
  public final TextView genres;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final LinearLayout layout;

  @NonNull
  public final LinearLayout layoutText;

  @NonNull
  public final TextView overview;

  @NonNull
  public final TextView rating;

  @NonNull
  public final TextView ratingTitle;

  @Bindable
  protected MovieDetails mFilmId;

  protected MovieDetailsFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView aboutTitle, CheckBox checkFavourite, TextView companies, TextView companiesTitle,
      TextView filmTitle, TextView genreTitle, TextView genres, ImageView imageView,
      LinearLayout layout, LinearLayout layoutText, TextView overview, TextView rating,
      TextView ratingTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.aboutTitle = aboutTitle;
    this.checkFavourite = checkFavourite;
    this.companies = companies;
    this.companiesTitle = companiesTitle;
    this.filmTitle = filmTitle;
    this.genreTitle = genreTitle;
    this.genres = genres;
    this.imageView = imageView;
    this.layout = layout;
    this.layoutText = layoutText;
    this.overview = overview;
    this.rating = rating;
    this.ratingTitle = ratingTitle;
  }

  public abstract void setFilmId(@Nullable MovieDetails filmId);

  @Nullable
  public MovieDetails getFilmId() {
    return mFilmId;
  }

  @NonNull
  public static MovieDetailsFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.movie_details_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static MovieDetailsFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<MovieDetailsFragmentBinding>inflateInternal(inflater, R.layout.movie_details_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static MovieDetailsFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.movie_details_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static MovieDetailsFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<MovieDetailsFragmentBinding>inflateInternal(inflater, R.layout.movie_details_fragment, null, false, component);
  }

  public static MovieDetailsFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static MovieDetailsFragmentBinding bind(@NonNull View view, @Nullable Object component) {
    return (MovieDetailsFragmentBinding)bind(component, view, R.layout.movie_details_fragment);
  }
}
