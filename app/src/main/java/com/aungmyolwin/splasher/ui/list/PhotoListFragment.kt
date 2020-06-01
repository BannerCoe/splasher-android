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
import com.aungmyolwin.splasher.ui.main.MainActivity
import com.aungmyolwin.splasher.utils.ParserUtils
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_photo_list.*
import timber.log.Timber
import javax.inject.Inject

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoListFragment : DaggerFragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    @Inject
    lateinit var parserUtils: ParserUtils

    lateinit var adapter: PhotoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_photo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm = ViewModelProvider(this, vmFactory).get(PhotoListViewModels::class.java)

        adapter = PhotoAdapter(parserUtils)
        initRecycler()


        vm.photos.observe(viewLifecycleOwner, Observer { photoPageList ->
            adapter.submitList(photoPageList)
        })

        adapter.setOnPhotoClickListener {
            Timber.d("banner: user click position: $it")
            (activity as? MainActivity)?.go2Detail(it)
        }

    }

    private fun initRecycler() {
        val gridItemDecoration = GridItemDecoration(requireContext())
        rv_photo_list.layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        rv_photo_list.addItemDecoration(gridItemDecoration)
        rv_photo_list.adapter = adapter
    }

}