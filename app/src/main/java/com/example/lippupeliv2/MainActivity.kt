package com.example.lippupeliv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var flagImageView: ImageView
    private lateinit var answerCard1: CardView
    private lateinit var answerCard2: CardView
    private lateinit var answerCard3: CardView
    private lateinit var answerCard4: CardView
    private lateinit var allFlagImageIds: MutableList<Int>
    private var topFlagImageId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cardslayout)

        val placeholderImage1 = findViewById<ImageView>(R.id.placeholder1)
        val placeholderImage2 = findViewById<ImageView>(R.id.placeholder2)
        val placeholderImage3 = findViewById<ImageView>(R.id.placeholder3)
        val placeholderImage4 = findViewById<ImageView>(R.id.placeholder4)
        flagImageView = findViewById(R.id.flag_image_view)
        answerCard1 = findViewById(R.id.answer_card_1)
        answerCard2 = findViewById(R.id.answer_card_2)
        answerCard3 = findViewById(R.id.answer_card_3)
        answerCard4 = findViewById(R.id.answer_card_4)
        placeholderImage1.setOnClickListener {
            // Hide placeholder image and show flags
            placeholderImage1.visibility = View.GONE
            answerCard1.visibility = View.VISIBLE
            answerCard2.visibility = View.VISIBLE
            answerCard3.visibility = View.VISIBLE
            answerCard4.visibility = View.VISIBLE
        }
        placeholderImage2.setOnClickListener {
            // Hide placeholder image and show flags
            placeholderImage2.visibility = View.GONE
            answerCard1.visibility = View.VISIBLE
            answerCard2.visibility = View.VISIBLE
            answerCard3.visibility = View.VISIBLE
            answerCard4.visibility = View.VISIBLE
        }
        placeholderImage3.setOnClickListener {
            // Hide placeholder image and show flags
            placeholderImage3.visibility = View.GONE
            answerCard1.visibility = View.VISIBLE
            answerCard2.visibility = View.VISIBLE
            answerCard3.visibility = View.VISIBLE
            answerCard4.visibility = View.VISIBLE
        }
        placeholderImage4.setOnClickListener {
            // Hide placeholder image and show flags
            placeholderImage4.visibility = View.GONE
            answerCard1.visibility = View.VISIBLE
            answerCard2.visibility = View.VISIBLE
            answerCard3.visibility = View.VISIBLE
            answerCard4.visibility = View.VISIBLE
        }

        allFlagImageIds = mutableListOf<Int>().apply {
            addAll(
                listOf(
                    R.drawable.ad,
                    R.drawable.al,
                    R.drawable.ba,
                    R.drawable.be,
                    R.drawable.de,
                    R.drawable.dk,
                    R.drawable.es,
                    R.drawable.fi,
                    R.drawable.fr,
                    R.drawable.gb,
                    R.drawable.it,
                    R.drawable.lt,
                    R.drawable.lu,
                    R.drawable.lv,
                    R.drawable.no,
                    R.drawable.ro,
                    R.drawable.se,
                    R.drawable.sk,
                    R.drawable.tr,
                    R.drawable.ua,
                    // Add more flag image resource IDs here as needed
                )
            )
        }

        answerCard1.setOnClickListener { handleAnswerClick(answerCard1) }
        answerCard2.setOnClickListener { handleAnswerClick(answerCard2) }
        answerCard3.setOnClickListener { handleAnswerClick(answerCard3) }
        answerCard4.setOnClickListener { handleAnswerClick(answerCard4) }

        setupNewGame()
    }

    private fun setupNewGame() {
        // Shuffle the list of all flag image resource IDs in the /res/drawable folder
        allFlagImageIds.shuffle()

        // Set the top flag image to a random flag from the shuffled list
        topFlagImageId = allFlagImageIds.random()
        flagImageView.setImageResource(topFlagImageId)

        // Remove the top flag image ID from the list of available flag images
        allFlagImageIds.remove(topFlagImageId)

        // Shuffle the list of available flag images to randomize the order
        allFlagImageIds.shuffle()

        // Set the answer options to random flags from the shuffled list
        answerCard1.setBackgroundResource(allFlagImageIds[0])
        answerCard2.setBackgroundResource(allFlagImageIds[1])
        answerCard3.setBackgroundResource(allFlagImageIds[2])
        answerCard4.setBackgroundResource(allFlagImageIds[3])

        // Set one of the answer options to match the top flag image
        val correctAnswerCard = listOf(answerCard1, answerCard2, answerCard3, answerCard4).random()
        correctAnswerCard.setBackgroundResource(topFlagImageId)
        val placeholderImage1 = findViewById<ImageView>(R.id.placeholder1)
        val placeholderImage2 = findViewById<ImageView>(R.id.placeholder2)
        val placeholderImage3 = findViewById<ImageView>(R.id.placeholder3)
        val placeholderImage4 = findViewById<ImageView>(R.id.placeholder4)
            // Hide placeholder image and show flags
            placeholderImage1.visibility = View.VISIBLE
            placeholderImage2.visibility = View.VISIBLE
        placeholderImage3.visibility = View.VISIBLE
        placeholderImage4.visibility = View.VISIBLE
    }

    private fun handleAnswerClick(selectedCard: CardView) {
        // Set the background image of each option to the random flag image that was previously set
        answerCard1.setBackgroundResource(allFlagImageIds[0])
        answerCard2.setBackgroundResource(allFlagImageIds[1])
        answerCard3.setBackgroundResource(allFlagImageIds[2])
        answerCard4.setBackgroundResource(allFlagImageIds[3])

        // Check if the selected option matches the top flag
        if (selectedCard.tag == topFlagImageId) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }
        setupNewGame();
    }
}
