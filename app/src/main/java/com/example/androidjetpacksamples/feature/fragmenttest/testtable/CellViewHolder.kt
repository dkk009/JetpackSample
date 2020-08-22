package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.view.View
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import kotlinx.android.synthetic.main.table_view_cell.view.*

class CellViewHolder(itemView: View) : AbstractViewHolder(itemView) {
    fun bindData(cellValue: String) {
        itemView.cell_tv.text = cellValue
    }

    fun getCellHeight(): Int {
        return itemView.measuredHeight
    }
}