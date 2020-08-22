package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.content.Context
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.util.SparseArray
import androidx.core.util.putAll
import androidx.recyclerview.widget.LinearLayoutManager
import com.evrencoskun.tableview.TableView
import timber.log.Timber

class CustomTableView : TableView, ICustomTableView {
    private var customCellLayoutManager: CustomCellLayoutManager? = null
    private var rowHeaderLayoutManager: LinearLayoutManager? = null
    private var cachedColumnHeight = SparseArray<Int>()
    private var rowContentLengthInfo = SparseArray<RowHeightInfo>()
    private var textBounds = Rect()
    private var textPaint = TextPaint()

    init {
        textPaint.textSize = 20f
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onCellLayoutIsCompleted() {
        val startPos = rowHeaderLayoutManager?.findFirstVisibleItemPosition() ?: 0
        val endPos = rowHeaderLayoutManager?.findLastVisibleItemPosition() ?: 0
        Timber.d("onCellLayoutIsCompleted:$startPos, Index:$endPos")
        var newItemFound = false
        //Timber.d("onCellLayoutIsCompleted : StartPos:$startPos, endPos:$endPos")
        for (index in startPos..endPos) {
            val view = rowHeaderLayoutManager?.findViewByPosition(index)
            if (view != null) {
                val rowCellContentInfo = rowContentLengthInfo[index]
                val cellIndex = rowCellContentInfo.columnIndex
                if (cachedColumnHeight.get(index, -1) == -1) {
                    val suitableHeight = getSuitableHeight(rowCellContentInfo.itemContent)
                    Timber.d("SuitableHeight:$suitableHeight, content:${rowCellContentInfo.itemContent}")
                    if (suitableHeight != -1) {
                        cachedColumnHeight.put(
                            index,
                            suitableHeight
                        )
                        newItemFound = true
                    }
                }
                /*if (cellIndex != -1) {
                    val cellHolder = customCellLayoutManager?.getCellViewHolder(cellIndex, index)

                    Timber.d("CellHolder:$cellHolder, Index:$index")
                    if (cellHolder != null) {

                        cellHolder?.itemView?.post {
                            Timber.d("onCellLayoutIsCompleted : RowPos:$index, Specified height:${cellHolder?.itemView?.measuredHeight},height:${cellHolder?.itemView?.layoutParams.height}")
                            val rowHeight = cachedColumnHeight.get(index, -1)
                            if (rowHeight != -1) {
                                view?.layoutParams.height = rowHeight
                                view?.requestLayout()
                            }
                        }
                    } else {
                        view?.post {
                            val suitableHeight = getSuitableHeight(rowCellContentInfo.itemContent)
                            view.layoutParams.height = suitableHeight
                            val firstCellHolder =
                                customCellLayoutManager?.getCellViewHolder(0, index)
                            firstCellHolder?.itemView?.post {
                                cachedColumnHeight.put(index, suitableHeight)
                                firstCellHolder.itemView.layoutParams.height = suitableHeight
                                // firstCellHolder.itemView.requestLayout()
                            }
                            Timber.d("Suitable height:$suitableHeight,index:$index,Content:$rowCellContentInfo, holder:${firstCellHolder?.itemView}")
                            // view?.requestLayout()
                        }
                    }
                }*/
            } else {
                Timber.d("Row Holder could not find, Index:$index, VisibleItem:${rowHeaderLayoutManager?.findFirstCompletelyVisibleItemPosition()}")
            }
            if (newItemFound) {
                adapter?.notifyDataSetChanged()
            }
        }
    }


    override fun getRowHeaderLayoutManager(): LinearLayoutManager {
        if (rowHeaderLayoutManager == null) {
            rowHeaderLayoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        return rowHeaderLayoutManager!!
    }

    override fun getCellLayoutManager(): CustomCellLayoutManager {
        if (customCellLayoutManager == null) {
            customCellLayoutManager = CustomCellLayoutManager(context, this)
        }
        return customCellLayoutManager!!
    }

    fun updateRowContentInfo(contentInfo: SparseArray<RowHeightInfo>) {
        rowContentLengthInfo.clear()
        rowContentLengthInfo.putAll(contentInfo)
    }


    private fun getTextWidth(itemText: String): Int {
        textPaint.getTextBounds(itemText, 0, itemText.length, textBounds)
        return textBounds.width()
    }

    fun getSuitableHeight(itemText: String): Int {
        val textWidth = getTextWidth(itemText)
        val textHeight = textBounds.height()
        val maxWidth = (context.resources.displayMetrics.density * Constants.TABLE_CELL_WIDTH).toInt()
        var calculatedHeight = 1
        if (maxWidth < textWidth) {
            calculatedHeight = Math.ceil((textWidth / maxWidth.toFloat()).toDouble()).toInt()
        }
        return calculatedHeight
    }

    fun getSuitableHeight(rowIndex: Int): Int {
        return cachedColumnHeight[rowIndex, -1]
    }
}