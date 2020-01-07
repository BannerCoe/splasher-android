package com.aungmyolwin.splasher.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aungmyolwin.splasher.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_photo_list.*
import javax.inject.Inject

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoListFragment : DaggerFragment() {
    private val adapter = PhotoAdapter()

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_photo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm = ViewModelProvider(this, vmFactory).get(PhotoListViewModels::class.java)

        initAdapter()

        vm.photos.observe(viewLifecycleOwner, Observer {
            adapter.setPhotos(it)
        })

        vm.loading.observe(viewLifecycleOwner, Observer {
            pb_loading.visibility = if (it) View.VISIBLE else View.INVISIBLE
        })

    }

    private fun initAdapter() {
        val gridItemDecoration = GridItemDecoration(requireContext())
        rv_photo_list.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        rv_photo_list.addItemDecoration(gridItemDecoration)
        rv_photo_list.adapter = adapter
    }

}