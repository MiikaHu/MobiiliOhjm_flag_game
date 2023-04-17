package com.example.lippupeliv2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val btnSubmit = findViewById<Button>(R.id.button_submit)
        val textInput = findViewById<EditText>(R.id.editTextTextPersonName)


        btnSubmit.setOnClickListener {
            val username = textInput.text.toString();

            //create intent to MainActivity screen
            val intent = Intent(this, MainActivity::class.java)

            //send username to MainActivity screen
            intent.putExtra("username", username)

            //sends to MainActivity
            startActivity(intent)
        }

    }
}