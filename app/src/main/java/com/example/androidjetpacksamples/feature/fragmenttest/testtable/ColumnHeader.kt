package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.view.View
import android.widget.LinearLayout
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import kotlinx.android.synthetic.main.table_view_cell.view.*

class ColumnHeaderViewHolder(itemView: View) : AbstractViewHolder(itemView) {
    fun bindData(cellValue: String) {
        itemView.cell_tv.text = cellValue
        itemView.cell_container_layout.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        itemView.cell_tv.requestLayout()
    }
}


class RowHeaderViewHolder(itemView: View) : AbstractViewHolder(itemView) {
    fun bindData(cellValue: String) {
        itemView.cell_tv.text = cellValue
        itemView.cell_container_layout.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        itemView.cell_tv.requestLayout()
    }

    fun getRowHeight(): Int {
        return itemView.measuredHeight
    }
}