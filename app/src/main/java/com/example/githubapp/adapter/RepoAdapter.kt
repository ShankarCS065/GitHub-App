package com.example.githubapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.githubapp.data.model.Repo
import com.example.githubapp.data.model.User
import com.example.githubapp.databinding.ItemUserBinding
import com.example.githubapp.fragment.ReposFragment

class RepoAdapter(private val context: Context) : RecyclerView.Adapter<RepoAdapter.UserViewHolder>() {


    private val list = ArrayList<Repo>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(repo:ArrayList<Repo>){
        list.clear()
        list.addAll(repo)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(val binding: ItemUserBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(repo:Repo){
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(repo)
                val uri = Uri.parse(repo.html_url)
                val intent = Intent(Intent.ACTION_VIEW,uri)
                context.startActivity(intent)
            }
            binding.apply {
                Glide.with(itemView)
                    .load(ReposFragment.url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ivUser)
                tvUsername.text = repo.full_name
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Repo)
    }
}