package com.example.tugaseureka.viewModel


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugaseureka.databinding.ActivityFollowingListBinding
import com.example.tugaseureka.model.UserModel

class FollowingAdapter(private val followersList: List<UserModel>) : RecyclerView.Adapter<FollowingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityFollowingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val follower = followersList[position]
        holder.bind(follower)
    }

    override fun getItemCount(): Int {
        return followersList.size
    }

    class ViewHolder(private val binding: ActivityFollowingListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserModel) {
            binding.followingName.text = user.login

            // Misalnya, jika Anda ingin menggunakan ImageView dengan Glide
            Glide.with(binding.root)
                .load(user.avatarUrl)
                .into(binding.avatarImageView)
        }
    }
}
