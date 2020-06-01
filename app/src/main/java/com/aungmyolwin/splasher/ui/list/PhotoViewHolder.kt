package com.aungmyolwin.splasher.ui.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aungmyolwin.splasher.utils.ParserUtils
import com.aungmyolwin.splasher.vo.Photo
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_photo.view.*

/**
 * a touch of AungMyoLwin on 8/2/18.
 *     made with <3
 */

class PhotoViewHolder(itemView: View, onClick: (jsonObj: String) -> Unit, parserUtils: ParserUtils) : RecyclerView.ViewHolder(itemView) {
    private lateinit var photo: Photo

    init {
        itemView.iv_row_photo.setOnClickListener {
            onClick(parserUtils.objectToString(photo))
        }
    }

    fun bind(photo: Photo?) {
        if (photo == null) return
        this.photo = photo
        Glide.with(itemView.context).load(this.photo.urls.small).into(itemView.iv_row_photo)
    }

}