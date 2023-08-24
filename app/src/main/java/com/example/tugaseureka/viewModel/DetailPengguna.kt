package com.example.tugaseureka.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.tugaseureka.R
import com.example.tugaseureka.databinding.ActivityDetailUserBinding
import com.example.tugaseureka.model.UserModel
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson

class DetailPengguna : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set default fragment when activity starts
        val defaultFragment = DefaultFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, defaultFragment)
            .commit()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Set the default color of the first tab to red and the second tab to blue
                binding.tabLayout.getTabAt(0)?.view?.setBackgroundColor(resources.getColor(R.color.colorRed))
                binding.tabLayout.getTabAt(1)?.view?.setBackgroundColor(resources.getColor(R.color.colorBlue))

                // Set the color of the selected tab to red
                tab.view?.setBackgroundColor(resources.getColor(R.color.colorRed))

                // Change fragment based on selected tab
                val selectedFragment: Fragment = when (tab.position) {
                    0 -> DefaultFragment() // Replace with your actual fragment for "Followers"
                    1 -> DefaultFragment() // Replace with your actual fragment for "Following"
                    else -> defaultFragment // Use the defaultFragment for other cases
                }

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, selectedFragment)
                    .commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Set the color of the unselected tab to blue
                tab.view?.setBackgroundColor(resources.getColor(R.color.colorBlue))
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
