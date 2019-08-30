package com.aungmyolwin.splasher.ui.list

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
    private var photoList = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_photo, parent, false))
    }

    override fun getItemCount(): Int = photoList.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

    fun setPhotos(photoList: List<Photo>) {
        this.photoList.addAll(photoList)
        notifyDataSetChanged()
    }
}