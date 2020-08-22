package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.evrencoskun.tableview.adapter.AbstractTableAdapter
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import com.example.androidjetpacksamples.R


class TableViewAdapter(
    private val context: Context,
    private val customTableView: CustomTableView
) :
    AbstractTableAdapter<Any?, Any?, Any?>() {

    override fun onCreateColumnHeaderViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder {
        // Get Cell xml Layout
        // Get Cell xml Layout
        val layout: View =
            LayoutInflater.from(parent!!.context).inflate(
                R.layout.table_view_cell,
                parent, false
            )
        return ColumnHeaderViewHolder(layout)
    }

    override fun onBindColumnHeaderViewHolder(
        holder: AbstractViewHolder,
        columnHeaderItemModel: Any?,
        columnPosition: Int
    ) {
        if (columnHeaderItemModel is ColumnHeader && holder is ColumnHeaderViewHolder) {
            holder.bindData(columnHeaderItemModel.name)
            val layoutParams = holder?.itemView.layoutParams
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT

            layoutParams.width =
                (context.resources.displayMetrics.density * Constants.TABLE_CELL_WIDTH).toInt()
            holder?.itemView.layoutParams = layoutParams
            holder?.itemView.requestLayout()
        }
    }

    override fun onBindRowHeaderViewHolder(
        holder: AbstractViewHolder,
        rowHeaderItemModel: Any?,
        rowPosition: Int
    ) {
        if (rowHeaderItemModel is RowHeader && holder is RowHeaderViewHolder) {
            holder.bindData(rowHeaderItemModel.name)
            val heightPreposition = customTableView.getSuitableHeight(rowPosition) ?: 1
            val layoutParams = holder.itemView.layoutParams
            layoutParams.height =
                (context.resources.displayMetrics.density * Constants.TABLE_CELL_HEIGHT).toInt()
            layoutParams.width =
                (context.resources.displayMetrics.density * Constants.TABLE_CELL_WIDTH).toInt()
            if (heightPreposition > 1) {
                layoutParams.height =
                    (heightPreposition * context.resources.displayMetrics.density * Constants.TABLE_CELL_HEIGHT).toInt()
            }
            holder.itemView.layoutParams = layoutParams
            holder.itemView.requestLayout()
        }
    }

    override fun onCreateRowHeaderViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder {
        val layout: View =
            LayoutInflater.from(parent!!.context).inflate(
                R.layout.table_view_cell,
                parent, false
            )
        return RowHeaderViewHolder(layout)
    }

    override fun getCellItemViewType(position: Int): Int {
        return 0
    }

    override fun onCreateCellViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        val layout: View =
            LayoutInflater.from(parent!!.context).inflate(
                R.layout.table_view_cell,
                parent, false
            )
        return CellViewHolder(layout)
    }

    override fun onCreateCornerView(parent: ViewGroup): View {
        val textView = TextView(context)
        return textView
    }

    override fun onBindCellViewHolder(
        holder: AbstractViewHolder,
        cellItemModel: Any?,
        columnPosition: Int,
        rowPosition: Int
    ) {
        if (cellItemModel is CellValue && holder is CellViewHolder) {
            holder.bindData(cellItemModel.name)
            val heightPreposition = customTableView.getSuitableHeight(rowPosition) ?: 1
            val layoutParams = holder.itemView.layoutParams
            layoutParams.height =
                (context.resources.displayMetrics.density * Constants.TABLE_CELL_HEIGHT).toInt()
            layoutParams.width =
                (context.resources.displayMetrics.density * Constants.TABLE_CELL_HEIGHT).toInt()
            if (heightPreposition > 1) {
                layoutParams.height =
                    (heightPreposition * (context.resources.displayMetrics.density * Constants.TABLE_CELL_HEIGHT)).toInt()
            }
            holder.itemView.layoutParams = layoutParams
            holder.itemView.requestLayout()
        }
    }

    override fun getColumnHeaderItemViewType(position: Int): Int {
        return 0
    }

    override fun getRowHeaderItemViewType(position: Int): Int {
        return 0
    }

}