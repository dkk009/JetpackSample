package com.example.androidjetpacksamples.feature.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.base.BindableAdapter
import com.example.androidjetpacksamples.base.OnItemClickListener
import com.example.androidjetpacksamples.databinding.ViewholderGithubRepoBinding
import com.example.androidjetpacksamples.feature.home.model.Repo
import timber.log.Timber

class AdapterRepoItem() : RecyclerView.Adapter<ViewHolderRepoItem>(), BindableAdapter<Repo> {
    private var repoList: List<Repo>? = null
    private var onItemClickListener: OnItemClickListener<Repo>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRepoItem {
        val binder = DataBindingUtil.inflate<ViewholderGithubRepoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.viewholder_github_repo,
            parent,
            false
        )
        return ViewHolderRepoItem(binder)
    }

    override fun getItemCount(): Int {
        return repoList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolderRepoItem, position: Int) {
        holder.onBindData(repoList?.get(position)!!, onItemClickListener)
    }

    override fun setData(data: List<Repo>) {
        repoList = data
        notifyDataSetChanged()
        Timber.d("setData:${data.size}")
    }

    override fun setOnItemClickListener(onItemClickListener: OnItemClickListener<Repo>?) {
        this.onItemClickListener = onItemClickListener
    }
}