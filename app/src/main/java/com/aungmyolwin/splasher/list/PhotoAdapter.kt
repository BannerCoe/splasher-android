package com.aungmyolwin.splasher.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aungmyolwin.splasher.R
import com.aungmyolwin.splasher.vo.Photo

/**
 * a touch of AungMyoLwin on 8/2/18.
 *     made with <3
 */

class PhotoAdapter : RecyclerView.Adapter<PhotoViewHolder>() {
    private var photoList: List<Photo>? = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_photo, parent, false))
    }

    override fun getItemCount(): Int = photoList?.size ?: 0


    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList?.get(position))
    }

    fun setPhotos(photoList: List<Photo>) {
        this.photoList = photoList
        notifyDataSetChanged()
    }
}