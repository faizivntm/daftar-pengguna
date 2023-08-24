package com.example.tugaseureka.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tugaseureka.R

class SplashScreen : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.splash_screen, container, false)
        Handler(Looper.getMainLooper()).postDelayed({
            val userListFragment = DaftarPengguna()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, userListFragment)
                .commit()
        }, 2000) //waktu
        return view
    }
}