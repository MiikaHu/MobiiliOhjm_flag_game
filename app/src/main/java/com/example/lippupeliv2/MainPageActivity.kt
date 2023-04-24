package com.example.lippupeliv2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainPageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val btnSubmit = findViewById<Button>(R.id.button_submit)
        val btnFlags = findViewById<Button>(R.id.button_flags)
        val textInput = findViewById<EditText>(R.id.editTextTextPersonName)

        btnFlags.setOnClickListener {
            val intent2 = Intent(this, flagsActivity::class.java)
            startActivity(intent2)

}

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
    override fun onResume() {
        super.onResume()
    /*    val prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val topFlagCard = prefs.getString("topFlagCard", null)
        if (topFlagCard != null) {
            val imageView = findViewById<ImageView>(R.id.flag_image_view)
            imageView.setImageURI(Uri.parse(topFlagCard))
        }
        val answerCard1Path = prefs.getString("answerCard1", null)
        if (answerCard1Path != null) {
            val imageView = findViewById<ImageView>(R.id.answer_card_1)
            imageView.setImageURI(Uri.parse(answerCard1Path))
        }
        val answerCard2Path = prefs.getString("answerCard2", null)
        if (answerCard2Path != null) {
            val imageView = findViewById<ImageView>(R.id.answer_card_2)
            imageView.setImageURI(Uri.parse(answerCard2Path))
        }
        val answerCard3Path = prefs.getString("answerCard3", null)
        if (answerCard3Path != null) {
            val imageView = findViewById<ImageView>(R.id.answer_card_3)
            imageView.setImageURI(Uri.parse(answerCard3Path))
        }
        val answerCard4Path = prefs.getString("answerCard4", null)
        if (answerCard4Path != null) {
            val imageView = findViewById<ImageView>(R.id.answer_card_4)
            imageView.setImageURI(Uri.parse(answerCard4Path))
        }*/
    }
}