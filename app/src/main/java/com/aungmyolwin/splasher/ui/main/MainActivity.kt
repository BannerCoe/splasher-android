package com.aungmyolwin.splasher.ui.main

import android.os.Bundle
import com.aungmyolwin.splasher.R
import com.aungmyolwin.splasher.ui.list.PhotoListFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private val tagListFrag = "tag_list_frag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = supportFragmentManager.findFragmentByTag(tagListFrag)
                ?: PhotoListFragment()

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_container, listFragment)
                .addToBackStack(tagListFrag)
                .commit()
    }
}
