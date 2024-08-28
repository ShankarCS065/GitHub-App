package com.example.githubapp.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.githubapp.R
import com.example.githubapp.adapter.RepoAdapter
import com.example.githubapp.adapter.UserAdapter
import com.example.githubapp.data.model.Repo
import com.example.githubapp.databinding.FragmentFollowBinding
import com.example.githubapp.databinding.FragmentFollowingBinding
import com.example.githubapp.databinding.FragmentReposBinding
import com.example.githubapp.ui.main.DetailUserActivity
import com.example.githubapp.viewModel.FollowingViewModel
import com.example.githubapp.viewModel.ReposViewModel

class ReposFragment:Fragment(R.layout.fragment_repos) {

    private var _binding: FragmentReposBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ReposViewModel
    private lateinit var adapter: RepoAdapter
    private lateinit var username:String
    companion object{
        lateinit var url:String
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        username = args?.getString(DetailUserActivity.EXTRA_USERNAME).toString()
        url = args?.getString(DetailUserActivity.URL).toString()
        _binding = FragmentReposBinding.bind(view)


        adapter = RepoAdapter(requireContext())
        adapter.notifyDataSetChanged()

        binding.apply {
            rvUser.setHasFixedSize(true)
            rvUser.layoutManager = LinearLayoutManager(activity)
            rvUser.adapter = adapter
        }

        showLoading(true)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            ReposViewModel::class.java)
        viewModel.setListRepo(username)
        viewModel.getListRepo().observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.setList(it)
                showLoading(false)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showLoading(state: Boolean){
        if(state){
            binding.progressbar.visibility = View.VISIBLE
        }else{
            binding.progressbar.visibility = View.GONE
        }
    }

}