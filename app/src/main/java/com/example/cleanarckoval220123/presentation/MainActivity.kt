package com.example.cleanarckoval220123.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarckoval220123.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAG", "MainActivity created")
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(this)
        ).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val getButton = findViewById<Button>(R.id.getButton)

        viewModel.resultLive.observe(this) {
            dataTextView.text = it
        }

        saveButton.setOnClickListener {
            val text = dataEditView.text.toString()
            viewModel.save(text)
        }

        getButton.setOnClickListener {
            viewModel.load()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "MainActivity destroyed")
    }
}

/*
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/pavelfire/CleanArcKoval.git
git push -u origin main
w10samsungSsdWork
 */

//https://www.youtube.com/watch?v=zt07bObIpSk&list=PLeF3l86ZMVkLQbdRL6Ra4cr_cmPROj94y&index=3