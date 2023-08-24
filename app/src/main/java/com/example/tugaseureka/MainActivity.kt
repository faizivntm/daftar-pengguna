package com.example.tugaseureka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.tugaseureka.view.SplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SplashScreen>(R.id.fragment_container_view)
            }
        }
    }
}