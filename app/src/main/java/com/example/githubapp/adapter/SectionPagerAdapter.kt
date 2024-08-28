package com.example.githubapp.adapter

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.githubapp.R
import com.example.githubapp.fragment.FollowersFragment
import com.example.githubapp.fragment.FollowingFragment
import com.example.githubapp.fragment.ReposFragment

class SectionPagerAdapter(private val mCtx: Context, fm: FragmentManager,data:Bundle):FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var fragmentBundle:Bundle

    init{
        fragmentBundle = data
    }

    @StringRes
    private val TAB_TITLES = intArrayOf(R.string.tab_1,R.string.tab_2,R.string.tab_3)

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        var fragment:Fragment? = null
        when(position){
            0 -> fragment = ReposFragment()
            1 -> fragment = FollowersFragment()
            2 -> fragment = FollowingFragment()
        }
        fragment?.arguments = this.fragmentBundle
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mCtx.resources.getString(TAB_TITLES[position])
    }

}