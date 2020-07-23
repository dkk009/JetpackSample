package com.example.androidjetpacksamples.feature.home

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.app.ScreenNavigation
import com.example.androidjetpacksamples.base.BaseViewModel
import com.example.androidjetpacksamples.base.OnItemClickListener
import com.example.androidjetpacksamples.feature.home.model.Repo
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) : BaseViewModel(),
    HomeViewModelUseCase, OnItemClickListener<Repo> {

    private val _repoListLiveData = MutableLiveData<List<Repo>>()
    private val _repoList = mutableListOf<Repo>()
    private val _screenNavigation = MutableLiveData<ScreenNavigation>()
    val screenNavigation: LiveData<ScreenNavigation>
        get() = _screenNavigation
    val repoListLiveData: LiveData<List<Repo>>
        get() = _repoListLiveData

    init {
        fetchPublicRepo()
    }

    override fun fetchPublicRepo() {
        viewModelScope.launch {
            val reposList = homeUseCase.fetchPublicRepo()
            _repoList.addAll(reposList)
            _repoListLiveData.value = _repoList

        }
    }

    override fun fetchRepoDetails(repoId: Long) {

    }

    override fun onItemClick(dataModel: Any, pos: Int, tag: String) {
        _screenNavigation.postValue(
            ScreenNavigation(
                data = dataModel as Parcelable,
                screenId = R.id.action_homeFragment_to_repoDetailsFragment
            )
        )
        Timber.d("Data item clicked:$pos")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("ViewModel OnCleared")
    }
}