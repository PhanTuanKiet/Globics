package com.globic.globics.base

import androidx.fragment.app.Fragment

interface OnAddFragmentFromActivityListener {
    fun onAddFragment(containerId: Int, fragment: Fragment?)
    fun onReplaceFragment(containerId: Int, fragment: Fragment?, hasBackStack: Boolean)
}