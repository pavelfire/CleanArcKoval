package com.example.cleanarckoval220123.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cleanarckoval220123.R
import com.example.cleanarckoval220123.data.repository.UserRepositoryImpl
import com.example.cleanarckoval220123.domain.models.SaveUserNameParam
import com.example.cleanarckoval220123.domain.models.UserName
import com.example.cleanarckoval220123.domain.usecase.GetUserNameUseCase
import com.example.cleanarckoval220123.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(context = applicationContext) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val getButton = findViewById<Button>(R.id.getButton)
        val recyclerButton = findViewById<Button>(R.id.recyclerButton)

        saveButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }

        getButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }

        recyclerButton.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }
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

/*
Clean architecture books
https://medium.com/nuances-of-programming/clean-architecture-в-android-для-начинающих-f44d25495f5b

https://habr.com/ru/post/459402/
https://proglib.io/p/clean-architecture-android-apps

dependency injection
https://devcolibri.com/basics-of-dependency-injection-for-dummies/

 */