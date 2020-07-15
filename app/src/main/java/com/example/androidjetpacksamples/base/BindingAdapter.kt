package com.example.androidjetpacksamples.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidjetpacksamples.feature.home.AdapterRepoItem

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
            adapter = AdapterRepoItem()
            recyclerView.adapter = adapter
        }
        if (recyclerView.adapter is BindableAdapter<*>) {
            if (data.value != null) {
                (recyclerView.adapter as BindableAdapter<T>).setData(data = data.value!!)
            } else {
                (recyclerView.adapter as BindableAdapter<T>).setData(data = emptyList())
            }
            (recyclerView.adapter as BindableAdapter<T>).setOnItemClickListener(onItemClickListener)
        }
    }

    @BindingAdapter("avatar")
    @JvmStatic
    fun loadAvatar(imageView: ImageView, url: String?) {
        if (url.isNullOrEmpty().not()) {
            Glide.with(imageView).load(url).submit()
        }
    }
}