package com.example.eplaymentexam.mvvmsample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.eplaymentexam.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {

            // Adds our fragment
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragment_container_view)
            }
        }
    }
}
