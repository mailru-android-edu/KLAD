package com.example.finema.ui.userProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finema.R
import com.example.finema.databinding.ProfileFragmentBinding
import com.example.finema.models.databaseModels.TopModel
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.downloadAndSetImageUri
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ProfileFragment :
    BaseFragment<ProfileViewModel, ProfileFragmentBinding>(),
    ProfileAdapter.ProfileHolder.Listener {

    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding
            .inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)

        binding.userName.text = viewModel.getName()
        binding.userPhone.text = viewModel.getNumber()
        binding.Avatar.downloadAndSetImageUri(viewModel.getImage())

        profileAdapter = ProfileAdapter(this)
        viewModel.topMovies.observe(
            viewLifecycleOwner,
            {
                it?.let {
                    binding.topRecycler.visibility = View.VISIBLE
                    profileAdapter.movies = it
                    binding.topRecycler.layoutManager = LinearLayoutManager(context)
                    binding.topRecycler.adapter = profileAdapter
                }
            }
        )
    }

    override fun onMovieClicked(movie: TopModel) {
        goDetailsFragment(movie.id)
    }

    private fun goDetailsFragment(filmIdInfo: Long) {
        val bundle = Bundle()
        bundle.putSerializable("filmId", filmIdInfo)
        Navigation.findNavController(requireActivity(), R.id.fragment)
            .navigate(R.id.action_fragment_profile_to_fragment_film, bundle)
    }
}
