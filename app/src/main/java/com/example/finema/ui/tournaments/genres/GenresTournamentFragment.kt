package com.example.finema.ui.tournaments.genres

import android.app.Dialog
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentGenresBinding
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.AppPreference
import org.koin.androidx.scope.scopeActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class GenresTournamentFragment(
) :
    BaseFragment<GenresTournamentVM, FragmentTournamentGenresBinding>(),
    GenresTournamentAdapter.TournamentHolder.Listener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: GenresTournamentAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTournamentGenresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        if (AppPreference.getGeneratedGenres()) {
            viewModel.genreListVM.observe(viewLifecycleOwner, observerList)
        }

        mAdapter = GenresTournamentAdapter(this)
        mRecyclerView = binding.tournamentsRecycler
        mRecyclerView.adapter = mAdapter

        viewModel.DBRepository.allGenres.observe(viewLifecycleOwner, mObserverList)

        //TODO Изменить на фрагмент
        viewModel.filmListVM.observe(viewLifecycleOwner, {
            dialogBinding(it)
        })
    }

    override fun onMovieClicked(view: View,
                                genreModelId: GenreModel)
    {
        viewModel.genreModel(genreModelId.id.toString())
    }

    private fun dialogBinding(list1: List<Movie>) {
        //TODO Заменить на нормальный контекст
        val dialog = Dialog(requireContext())

        //TODO Dialog(APP_ACTIVITY).let {
        //            it.setContentView(R.layout.number_fragment)
        //            it.findViewById<View>(R.id.btn8).setOnClickListener { _ ->
        //                goNext(8, list1)
        //                it.hide()
        //            }
        //        }

        dialog.setContentView(R.layout.number_fragment)

        val btn8: TextView = dialog.findViewById(R.id.btn8)
        val btn16: Button = dialog.findViewById(R.id.btn16)
//        val btn32: Button = dialog.findViewById(R.id.btn32)
//        val btn64: Button = dialog.findViewById(R.id.btn64)
//        val btn128: Button = dialog.findViewById(R.id.btn128)

        btn8.setOnClickListener {
            goNext(8, list1)
            dialog.hide()
        }
        btn16.setOnClickListener {
            goNext(16, list1)
            dialog.hide()
        }
//        btn32.setOnClickListener {
//            goNext(32)
//            dialog.hide()
//        }
//        btn64.setOnClickListener {
//            goNext(64)
//            dialog.hide()
//        }
//        btn128.setOnClickListener {
//            goNext( 128)
//            dialog.hide()
//        }
        dialog.show()
    }

    private fun goNext(num: Int, list1: List<Movie>) {
        val bundle = Bundle()
        bundle.putParcelableArrayList("list", list1 as java.util.ArrayList<out Parcelable>)
        bundle.putSerializable("num", num)
//        TODO FragmentGenreDestinations.action(_, _, _)
//        TODO findNavController() ?
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
            .navigate(R.id.action_fragmentGenre_to_fragmentTournament, bundle)
    }

    private val observerList: Observer<GenreList> = Observer {
        for (item in it.genres) {
            viewModel.insert(
                GenreModel(name = item.name, id = item.id)
            )
        }
            Log.d("testLog", "Row inserted")

    }

    private val mObserverList: Observer<List<GenreModel>> = Observer {
        mAdapter.setList(it)
    }


}
