package com.example.tugaseureka.viewModel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.tugaseureka.R
import com.example.tugaseureka.databinding.ActivityDetailUserBinding
import com.example.tugaseureka.model.UserModel
import com.example.tugaseureka.view.FollowersFragment
import com.example.tugaseureka.view.FollowingFragment
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson

class DetailPengguna : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set default fragment when activity starts
        val defaultFragment = FollowersFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, defaultFragment)
            .commit()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Set the default color of the first tab to red and the second tab to blue



                // Change fragment based on selected tab
                val selectedFragment: Fragment = when (tab.position) {
                    0 -> FollowersFragment()
                    1 -> FollowingFragment()
                    else -> FollowersFragment()
                }

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, selectedFragment)
                    .commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Set the color of the unselected tab to blue
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        val userJson = intent.getStringExtra("userJson")
        if (userJson != null) {
            val user = Gson().fromJson(userJson, UserModel::class.java)

            binding.loginTextView.text = user.login

            Glide.with(this)
                .load(user.avatarUrl)
                .into(binding.avatarImageView)
        }
    }
}
