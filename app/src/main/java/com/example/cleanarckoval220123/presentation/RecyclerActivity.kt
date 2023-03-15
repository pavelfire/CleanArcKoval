package com.example.cleanarckoval220123.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarckoval220123.R

import com.example.cleanarckoval220123.presentation.ui.main.RecyclerFragment

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecyclerFragment.newInstance())
                .commitNow()
        }
    }
}