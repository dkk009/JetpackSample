package com.example.androidjetpacksamples.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.Observer
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.base.BaseFragment
import com.example.androidjetpacksamples.base.IntrNavGraph
import com.example.androidjetpacksamples.base.LoginResource
import com.example.androidjetpacksamples.databinding.FragmentLoginBinding
import com.example.androidjetpacksamples.extension.hideKeyBoard
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
        loginViewModel.loginLiveData.observe(viewLifecycleOwner, loginDataObserver())
    }

    private fun loginDataObserver(): Observer<in LoginResource> {
        return Observer {
            if (null != it) {
                when (it) {
                    is LoginResource.LoginStatus -> {
                        if (it.isLogin) {
                            if (activity is IntrNavGraph) {
                                hideKeyBoard()
                                (activity as IntrNavGraph).updateNavGraph(navGraphId = R.navigation.nav_home)
                            }
                        }
                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        fragmentLoginBinding = null
        super.onDestroyView()
    }
}