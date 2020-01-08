package com.aungmyolwin.splasher.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aungmyolwin.splasher.R
import com.aungmyolwin.splasher.utils.ParserUtils
import com.aungmyolwin.splasher.vo.Photo

/**
 * a touch of AungMyoLwin on 8/2/18.
 *     made with <3
 */

class PhotoAdapter(private val parserUtils: ParserUtils) : RecyclerView.Adapter<PhotoViewHolder>() {
    private var photoList = mutableListOf<Photo>()
    private lateinit var onClick: (String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_photo, parent, false), onClick, parserUtils = parserUtils)
    }

    override fun getItemCount(): Int = photoList.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

    fun setPhotos(photoList: List<Photo>) {
        this.photoList.addAll(photoList)
        notifyDataSetChanged()
    }

    fun setOnPhotoClickListener(onClick: (String) -> Unit) {
        this.onClick = onClick
    }
}