package com.example.androidjetpacksamples.feature.home

import androidx.recyclerview.widget.RecyclerView
import com.example.androidjetpacksamples.base.OnItemClickListener
import com.example.androidjetpacksamples.databinding.ViewholderGithubRepoBinding
import com.example.androidjetpacksamples.feature.home.model.Repo

class ViewHolderRepoItem(private val viewholderBinder: ViewholderGithubRepoBinding) :
    RecyclerView.ViewHolder(viewholderBinder.root) {

    fun onBindData(dataModel: Repo, onItemClickListener: OnItemClickListener<Repo>?) {
        viewholderBinder.dataModelRepo = dataModel
        viewholderBinder.onItemClickListener = onItemClickListener
        viewholderBinder.pos = adapterPosition
        viewholderBinder.executePendingBindings()
    }
}