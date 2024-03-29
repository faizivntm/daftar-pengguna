package com.example.tugaseureka.viewModel
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugaseureka.databinding.ActivityUserListBinding
import com.example.tugaseureka.model.UserModel
import com.google.gson.Gson


class UserAdapter(private val users: List<UserModel>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityUserListBinding.inflate(inflater, parent, false) // Ganti dengan layout item yang sesuai
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)

        // Menambahkan event klik pada item
        holder.itemView.setOnClickListener {
            Log.d("Testing", "Click")
            Toast.makeText(holder.itemView.context, "Ini adalah akun "+user.login, Toast.LENGTH_SHORT).show()

            val context = holder.itemView.context
            val intent = Intent(context, DetailPengguna::class.java)
            val userJson = Gson().toJson(user) // Mengubah UserModel menjadi JSON string
            intent.putExtra("userJson", userJson) // Mengirim JSON string
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class UserViewHolder(private val binding: ActivityUserListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserModel) {
            binding.loginTextView.text = user.login

            Glide.with(binding.root)
                .load(user.avatarUrl)
                .into(binding.avatarImageView)
        }
    }
}

