package com.example.finema.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finema.R
import com.example.finema.databinding.FavouriteFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import org.koin.androidx.viewmodel.ext.android.getViewModel

class FavouriteFragment : BaseFragment<FavouriteViewModel, FavouriteFragmentBinding>() {

    private val favouriteAdapter = FavouriteAdapter {
        val action = FavouriteFragmentDirections.actionFragmentFavouriteToFragmentFilm(it)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FavouriteFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)

        content()

        binding.choose.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentFavourite_to_chooseFavouriteFragment)
        }
    }

    private fun content() {
        viewModel.favouriteMovies.observe(
            viewLifecycleOwner,
            {
                it?.let {
                    binding.searchLoader.visibility = View.INVISIBLE
                    binding.moviesList.visibility = View.VISIBLE
                    favouriteAdapter.update(it)

                    if (it.isEmpty()) {
                        binding.choose.visibility = View.VISIBLE
                    } else {
                        binding.choose.visibility = View.INVISIBLE
                    }

                    binding.moviesList.layoutManager = flexBox()
                    binding.moviesList.adapter = favouriteAdapter
                }
            }
        )
    }

    private fun flexBox(): FlexboxLayoutManager {
        val flex = FlexboxLayoutManager(context)
        flex.flexDirection = FlexDirection.ROW
        flex.alignItems = AlignItems.CENTER
        flex.justifyContent = JustifyContent.CENTER
        return flex
    }
}
