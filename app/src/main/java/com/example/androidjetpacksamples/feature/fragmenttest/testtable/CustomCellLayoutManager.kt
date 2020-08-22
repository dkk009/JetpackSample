package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.evrencoskun.tableview.layoutmanager.CellLayoutManager
import timber.log.Timber

class CustomCellLayoutManager : CellLayoutManager {
    private var tableView: ICustomTableView

    constructor(context: Context, tableView: ICustomTableView) : super(context, tableView) {
        this.tableView = tableView
    }

    override fun onLayoutCompleted(state: RecyclerView.State?) {
        super.onLayoutCompleted(state)
        Timber.d("onLayoutCompleted:$tableView")
        tableView?.onCellLayoutIsCompleted()
    }
}