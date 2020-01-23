package com.aungmyolwin.splasher.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aungmyolwin.splasher.R
import com.aungmyolwin.splasher.utils.ParserUtils
import com.aungmyolwin.splasher.vo.Photo
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.view.*

/**
 * a touch of amlwin on 2020-01-08.
 * made with <3
 */

class DetailFragment : Fragment() {


    private lateinit var rootView: View

    private lateinit var vm: DetailViewModel

    companion object {
        val keyRawString = "key_detail_raw_string"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(this)[DetailViewModel::class.java]

        vm.photoUrl.observe(viewLifecycleOwner, Observer {
            Glide.with(this)
                    .load(it)
                    .into(rootView.iv_preview)
        })

        if (arguments != null) {
            val rawString = arguments?.getString(keyRawString) ?: return
            val photo: Photo = ParserUtils().stringToObject(rawString, Photo::class.java)
            vm.loadPhoto(photo)
        }
    }
}