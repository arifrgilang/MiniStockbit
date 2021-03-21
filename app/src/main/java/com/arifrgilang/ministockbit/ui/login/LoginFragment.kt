package com.arifrgilang.ministockbit.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arifrgilang.domain.base.state.FormState
import com.arifrgilang.domain.base.state.UiState
import com.arifrgilang.ministockbit.ui.MainActivity
import com.arifrgilang.ministockbit.R
import com.arifrgilang.ministockbit.base.BaseBindingFragment
import com.arifrgilang.ministockbit.databinding.FragmentLoginBinding
import com.arifrgilang.ministockbit.util.*
import com.orhanobut.hawk.Hawk
import org.jetbrains.anko.support.v4.toast
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : BaseBindingFragment<FragmentLoginBinding>() {
    private val viewModel by viewModel<LoginViewModel>()

    override fun contentView(): Int = R.layout.fragment_login

    override fun setupData(savedInstanceState: Bundle?) {
        checkUserToken()
        observeViewModel()
    }

    override fun setupView() {
        binding.btnLogin.setOnClickListener {
            viewModel.login(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )
        }
    }

    private fun checkUserToken() {
        if(Hawk.get<String>(Constant.USER_TOKEN) != null) {
            navigateToWatchlist()
        }
    }

    private fun observeViewModel() {
        observe(viewModel.formState, ::onFormValidate)
        observe(viewModel.uiState, ::onLoading)
    }

    private fun onFormValidate(state: FormState) {
        validationHandler(state,
            onInvalid = { toast("Email and Password is required") },
            onValid = { navigateToWatchlist() }
        )
    }

    private fun onLoading(state: UiState) {
        loadHandler(state,
            onLoading = { showLoadingState() },
            onSuccess = {
                hideLoadingState()
                navigateToWatchlist() },
            onError = {
                hideLoadingState()
                it.message?.let{ message -> toast(message) }
            }
        )
    }

    private fun showLoadingState() {
        binding.btnLogin.gone()
        binding.btnLoading.visible()
    }

    private fun hideLoadingState() {
        binding.btnLogin.visible()
        binding.btnLoading.gone()
    }

    private fun navigateToWatchlist() {
        val action = LoginFragmentDirections.actionLoginFragmentToWatchlistFragment()
        if(findNavController().currentDestination?.id == R.id.loginFragment) {
            findNavController().navigate(action)
        }
    }

    override fun onResume() {
        (activity as MainActivity).hideBottomNavBar()
        (activity as MainActivity).setMenuHidden(true)
        super.onResume()
    }

    override fun onDetach() {
        (activity as MainActivity).showBottomNavBar()
        (activity as MainActivity).setMenuHidden(false)
        super.onDetach()
    }
}