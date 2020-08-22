package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.view.View
import kotlinx.android.synthetic.main.layout_view_holder_two.view.*

class ViewHolderTwo(view: View) : BaseViewHolder<ItemTypeTwo>(view) {
    override fun bindData(data: ItemTypeTwo) {
        itemView.txtName.text = data.name
    }
}