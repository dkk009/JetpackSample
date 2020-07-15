package com.example.androidjetpacksamples.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.base.BaseFragment
import com.example.androidjetpacksamples.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : BaseFragment() {
    private var fragmentLoginBinding: FragmentLoginBinding? = null
    private lateinit var etUserName: EditText

    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        fragmentLoginBinding?.viewmodel = loginViewModel
        fragmentLoginBinding?.loginData = loginViewModel.getInitialLoginUiData()
        fragmentLoginBinding?.lifecycleOwner = this
        return fragmentLoginBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding!!.buttonSignIn.setOnClickListener { }

    }


    override fun onDestroyView() {
        fragmentLoginBinding = null
        super.onDestroyView()
    }
}