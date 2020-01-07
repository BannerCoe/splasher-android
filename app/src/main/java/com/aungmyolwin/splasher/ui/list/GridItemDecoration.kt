package com.aungmyolwin.splasher.ui.list

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * a touch of amlwin on 2019-12-20.
 * made with <3
 */

class GridItemDecoration(val context: Context) : RecyclerView.ItemDecoration() {

    private val defaultSpacing = 2
    private val spacing: Int = defaultSpacing * context.resources.displayMetrics.density.toInt()

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = spacing
        outRect.left = spacing
        outRect.top = spacing
        outRect.right = spacing
    }
}