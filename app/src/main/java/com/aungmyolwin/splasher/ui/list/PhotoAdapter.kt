package com.aungmyolwin.splasher.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.aungmyolwin.splasher.R
import com.aungmyolwin.splasher.utils.ParserUtils
import com.aungmyolwin.splasher.vo.Photo

/**
 * a touch of AungMyoLwin on 8/2/18.
 *     made with <3
 */

class PhotoAdapter(private val parserUtils: ParserUtils) : PagedListAdapter<Photo, PhotoViewHolder>(photoDiffCallback) {
    private lateinit var onClick: (String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_photo, parent, false), onClick, parserUtils = parserUtils)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setOnPhotoClickListener(onClick: (String) -> Unit) {
        this.onClick = onClick
    }
}

val photoDiffCallback = object : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return (oldItem.id == newItem.id)
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return (oldItem.urls.small == newItem.urls.small) && (oldItem.color == newItem.color)
    }

}