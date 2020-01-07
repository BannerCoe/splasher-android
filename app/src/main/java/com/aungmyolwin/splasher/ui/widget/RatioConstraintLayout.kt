package com.aungmyolwin.splasher.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * a touch of amlwin on 2020-01-07.
 * made with <3
 */

class RatioImageView : ImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttri: Int) : super(context, attributeSet, defStyleAttri)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec)
    }
}