package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.util.SparseArray

interface BaseUiModel {
    val uiType: Int
}

data class ItemTypeOne(val name: String, override val uiType: Int) : BaseUiModel
data class ItemTypeTwo(val name: String, override val uiType: Int) : BaseUiModel

data class TableInfo(
    val name: String,
    val columnHeader: List<ColumnHeader>,
    val rowHeader: List<RowHeader>,
    val cellValue: List<List<CellValue>>,
    val rowContentLengthInfo: SparseArray<RowHeightInfo>,
    override val uiType: Int
) : BaseUiModel

data class ColumnHeader(val name: String)
data class RowHeader(val name: String)
data class CellValue(val name: String)
