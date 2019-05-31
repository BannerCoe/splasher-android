package com.aungmyolwin.splasher.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungmyolwin.splasher.Injector
import com.aungmyolwin.splasher.R
import com.aungmyolwin.splasher.vo.Status
import kotlinx.android.synthetic.main.fragment_photo_list.*

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoListFragment : Fragment() {
    private val adapter = PhotoAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_photo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        val factory = Injector.provideViewModelFactory()
        val viewModels = ViewModelProviders.of(this, factory).get(PhotoListViewModels::class.java)

        viewModels.setClient(/*BuildConfig.ACCESS_KEY*/"some key")

        viewModels.photos.observe(this, Observer {
            if (it.status == Status.LOADING) {
                //Todo show loading here
            }

            if (it.status == Status.SUCCESS && it.data != null)
                adapter.setPhotos(it.data)

        })

    }

    private fun initAdapter() {
        rv_photo_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_photo_list.adapter = adapter
    }

}