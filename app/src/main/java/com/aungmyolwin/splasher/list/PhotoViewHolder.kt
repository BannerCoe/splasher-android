package com.aungmyolwin.splasher.list

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.aungmyolwin.splasher.R
import com.aungmyolwin.splasher.vo.Photo
import com.bumptech.glide.Glide

/**
 * a touch of AungMyoLwin on 8/2/18.
 *     made with <3
 */

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var photoView: AppCompatImageView = itemView.findViewById(R.id.iv_row_photo)

    fun bind(photo: Photo?) {
        Glide.with(itemView.context).load(photo?.urls?.small).into(photoView)
    }

}