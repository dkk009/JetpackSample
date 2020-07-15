package com.example.androidjetpacksamples.base

interface BindableAdapter<T> {
    fun setData(data: List<T>)
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>?)
}