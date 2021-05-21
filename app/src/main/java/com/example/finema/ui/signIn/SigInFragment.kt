package com.example.finema.ui.signIn

import android.app.Instrumentation
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.finema.R
import com.example.finema.databinding.SignInFragmentBinding
import com.example.finema.repositories.Contract
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.AppPreference
import com.example.finema.util.TYPE_ROOM
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import org.koin.androidx.viewmodel.ext.android.getViewModel


class SigInFragment: BaseFragment<SignInViewModel, SignInFragmentBinding>() {

    //TODO убрать, есть биндинг
    private lateinit var header: TextView

    private val customContract = registerForActivityResult(Contract()) {
        header.text = it?.currentUser?.displayName!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(inflater, container, false)
        // ���� ������������ �����������, �� �������� ����������� ���������
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()

        super.onViewCreated(view, savedInstanceState)

        //TODO вынести во Repository, но только после того как будет DI (dagger/koin)

        header = requireActivity().findViewById<NavigationView>(R.id.nav_view)
            .getHeaderView(0).findViewById(R.id.nickProfile)

        binding.signInWithGoogle.setOnClickListener{
            signIn()
            AppPreference.setInitUser(true)
            findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
        }

        binding.signInAsGuest.setOnClickListener{
            AppPreference.setInitUser(true)
            header.text = resources.getText(R.string.guest)
            findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
        }
    }

    //TODO репозиторий по нажатию на кнопку возвращает интент, через VM, который и надо здесь
    // запускать
    private fun signIn() {
        customContract.launch(Unit)
    }

}