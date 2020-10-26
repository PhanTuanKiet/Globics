package com.globic.globics.base

import androidx.fragment.app.Fragment
import dagger.android.DaggerActivity

class BaseActivity : DaggerActivity(), OnAddFragmentFromActivityListener {

    override fun onAddFragment(containerId: Int, fragment: Fragment?) {
        TODO("Not yet implemented")
    }

    override fun onReplaceFragment(containerId: Int, fragment: Fragment?, hasBackStack: Boolean) {
        TODO("Not yet implemented")
    }


}