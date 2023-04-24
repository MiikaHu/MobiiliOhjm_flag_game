package com.example.lippupeliv2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinishScreen : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_screen)

        //Get score from MainActivity tab when OnFinish func. is called
        val highestScore = intent.getIntExtra("highestScore", 0)
        val score = intent.getIntExtra("score", 0)
        // set the text of the highest score text view
        val highestScoreTextView = findViewById<TextView>(R.id.highest_score_text_view)
        highestScoreTextView.text = "Highest Score: $highestScore"
        val tView = findViewById<TextView>(R.id.textView)
        val btnTry = findViewById<Button>(R.id.btn_try)


        tView.text ="Rip... score: " +  score.toString()


        //btnTry button sends back to MainActivity
        btnTry.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}