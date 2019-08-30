package com.aungmyolwin.splasher.ui.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aungmyolwin.splasher.vo.Photo
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_photo.view.*

/**
 * a touch of AungMyoLwin on 8/2/18.
 *     made with <3
 */

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(photo: Photo?) {
        Glide.with(itemView.context).load(photo?.urls?.small).into(itemView.iv_row_photo)
    }

}