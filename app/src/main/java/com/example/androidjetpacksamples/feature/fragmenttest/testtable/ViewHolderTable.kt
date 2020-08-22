package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.view.View
import kotlinx.android.synthetic.main.viewholder_table.view.*

class ViewHolderTable(view: View, private val tableData: TableInfo) :
    BaseViewHolder<TableInfo>(view) {
    private val tableViewAdapter = TableViewAdapter(itemView.context, itemView.table_view)
    private var isShown = false

    init {
        tableViewAdapter.tableView = itemView.table_view
        itemView.table_view.setAdapter(tableViewAdapter)
        itemView.table_view.setHasFixedWidth(true)
        itemView.table_view.rowHeaderWidth =
            (view.context.resources.displayMetrics.density * 120).toInt()

        itemView.table_view.updateRowContentInfo(tableData.rowContentLengthInfo)
        tableViewAdapter.setAllItems(
            tableData.columnHeader,
            tableData.rowHeader,
            tableData.cellValue
        )
        itemView.txtShowTable.setOnClickListener {
            isShown = !isShown
            itemView.table_view.visibility = if (isShown) View.VISIBLE else View.GONE
        }

    }

    override fun bindData(data: TableInfo) {

    }
}