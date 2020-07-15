package com.example.androidjetpacksamples.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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
        Timber.d("ItemClicked:$pos, data:$dataModel")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("ViewModel OnCleared")
    }
}