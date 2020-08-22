package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjetpacksamples.R

class RVAdapter(private val itemList: List<BaseUiModel>) :
    RecyclerView.Adapter<BaseViewHolder<BaseUiModel>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseUiModel> {
        return when (viewType) {
            R.layout.layout_view_holder_one -> {
                ViewHolderOne(
                    LayoutInflater.from(parent.context).inflate(viewType, parent, false)
                ) as BaseViewHolder<BaseUiModel>
            }
            R.layout.layout_view_holder_two -> {
                ViewHolderTwo(
                    LayoutInflater.from(parent.context).inflate(viewType, parent, false)
                ) as BaseViewHolder<BaseUiModel>
            }
            R.layout.viewholder_table -> {
                val tableData = itemList.filterIsInstance<TableInfo>().first()
                ViewHolderTable(
                    LayoutInflater.from(parent.context).inflate(viewType, parent, false), tableData
                ) as BaseViewHolder<BaseUiModel>
            }
            else -> throw IllegalArgumentException("View not found")
        }
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: BaseViewHolder<BaseUiModel>, position: Int) {
        holder.bindData(itemList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].uiType
    }


}