package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import com.evrencoskun.tableview.ITableView

interface ICustomTableView : ITableView {
    fun onCellLayoutIsCompleted()
}