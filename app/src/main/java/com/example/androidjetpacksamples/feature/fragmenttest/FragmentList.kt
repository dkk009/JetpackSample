package com.example.androidjetpacksamples.feature.fragmenttest

import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.feature.fragmenttest.testtable.*
import kotlinx.android.synthetic.main.fragment_test_list.*

class FragmentList : Fragment(R.layout.fragment_test_list) {
    private val itemList = mutableListOf<BaseUiModel>()
    private val rvAdapter = RVAdapter(itemList)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvList.layoutManager = LinearLayoutManager(context)
        rvList.adapter = rvAdapter
        populateTheData()
        buttonClickMe.setOnClickListener {
            rvAdapter.notifyDataSetChanged()
        }
    }

    private fun populateTheData() {
        itemList.add(ItemTypeOne("1", R.layout.layout_view_holder_one))
        itemList.add(ItemTypeOne("2", R.layout.layout_view_holder_one))
        itemList.add(ItemTypeTwo("3", R.layout.layout_view_holder_two))
        itemList.add(ItemTypeTwo("4", R.layout.layout_view_holder_two))
        itemList.add(ItemTypeOne("5", R.layout.layout_view_holder_one))

        val listColumnHeader = mutableListOf<ColumnHeader>()
        for (i in 0 until 10) {
            listColumnHeader.add(ColumnHeader("Column Header:$i"))
        }
        val listRowHeader = mutableListOf<RowHeader>()
        val listCellItem = mutableListOf<List<CellValue>>()
        val listRowContentInfo = SparseArray<RowHeightInfo>()
        for (rowIndex in 0 until 10) {
            val rowHeader = RowHeader("Row Header:$rowIndex")
            listRowHeader.add(rowHeader)
            val rowHeightInfo = RowHeightInfo(rowIndex = rowIndex, itemContent = rowHeader.name)
            listRowContentInfo.put(rowIndex, rowHeightInfo)
            val cellItemList = mutableListOf<CellValue>()
            for (cellIndex in 0 until 10) {
                var cellValue = if (rowIndex%3==0 && cellIndex == rowIndex) {
                    CellValue("jhsajhj jhsajh ajjhdhjhjhjhjh Cell Value[$rowIndex,$cellIndex]")
                } else {
                    CellValue("Cell Value[$rowIndex,$cellIndex]")
                }
                if (rowHeightInfo.itemContent.length < cellValue.name.length) {
                    rowHeightInfo.columnIndex = cellIndex
                    rowHeightInfo.itemContent = cellValue.name
                    listRowContentInfo.put(rowIndex, rowHeightInfo)
                }
                cellItemList.add(cellValue)
            }
            listCellItem.add(cellItemList)
        }
        val tableInfo = TableInfo(
            "Table-6",
            columnHeader = listColumnHeader,
            rowHeader = listRowHeader,
            cellValue = listCellItem,
            uiType = R.layout.viewholder_table, rowContentLengthInfo = listRowContentInfo
        )

        itemList.add(tableInfo)
        for (i in 1..20) {
            itemList.add(ItemTypeOne("${i + 6}", R.layout.layout_view_holder_one))
            itemList.add(ItemTypeOne("${i + 7}", R.layout.layout_view_holder_one))
            itemList.add(ItemTypeTwo("${i + 8}", R.layout.layout_view_holder_two))
            itemList.add(ItemTypeTwo("${i + 9}", R.layout.layout_view_holder_two))
            itemList.add(ItemTypeOne("${i + 10}", R.layout.layout_view_holder_one))
        }
    }

}