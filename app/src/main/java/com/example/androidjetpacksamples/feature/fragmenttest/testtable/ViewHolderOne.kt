package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.view.View
import kotlinx.android.synthetic.main.layout_view_holder_one.view.*

class ViewHolderOne(view: View) : BaseViewHolder<ItemTypeOne>(view) {
    override fun bindData(data: ItemTypeOne) {
        itemView.txtName.text = data.name
    }
}

