package com.example.androidjetpacksamples.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidjetpacksamples.feature.home.AdapterRepoItem
import com.example.androidjetpacksamples.feature.home.model.Repo
import timber.log.Timber

object BindingAdapter {
    @BindingAdapter("itemList", "itemClickListener")
    @JvmStatic
    fun <T> setRecyclerViewProperties(
        recyclerView: RecyclerView,
        data: LiveData<List<T>>,
        onItemClickListener: OnItemClickListener<T>?
    ) {
        var adapter = recyclerView.adapter as? AdapterRepoItem
        if (adapter == null) {
            adapter = AdapterRepoItem(data.value as? List<Repo> ?: emptyList<Repo>())
            recyclerView.adapter = adapter
        }
        if (recyclerView.adapter is BindableAdapter<*>) {
            (recyclerView.adapter as BindableAdapter<T>).setOnItemClickListener(onItemClickListener)
            adapter.notifyDataSetChanged()
        }
    }

    @BindingAdapter("avatar")
    @JvmStatic
    fun loadAvatar(imageView: ImageView, url: String?) {
        imageView.setImageResource(0)
        if (url.isNullOrEmpty().not()) {
            Glide.with(imageView).load(url).into(imageView)
        }
    }
}