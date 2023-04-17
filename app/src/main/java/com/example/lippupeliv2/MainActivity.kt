package com.example.lippupeliv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView



class MainActivity : AppCompatActivity() {

    private lateinit var flagImageView: ImageView
    private lateinit var answerCard1: CardView
    private lateinit var answerCard2: CardView
    private lateinit var answerCard3: CardView
    private lateinit var answerCard4: CardView
    private lateinit var allFlagImageIds: MutableList<Int>
    private lateinit var correctAnswersTextView: TextView
    private var topFlagImageId: Int = -1
    private var correctAnswers: Int = 0
    private lateinit var timerTextView: TextView
    private lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {

        //Creates intent to FinishScreen when onFinish() is called
        val intent = Intent(this, FinishScreen::class.java)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.cardslayout)

        //Gets profilename from MainPageActivity tab
        val profileName = intent.getStringExtra("username")

        correctAnswersTextView = findViewById(R.id.correct_answers_text_view)
        flagImageView = findViewById(R.id.flag_image_view)
        answerCard1 = findViewById(R.id.answer_card_1)
        answerCard2 = findViewById(R.id.answer_card_2)
        answerCard3 = findViewById(R.id.answer_card_3)
        answerCard4 = findViewById(R.id.answer_card_4)

        timerTextView = findViewById(R.id.timer_text_view)
        Log.i(profileName, "profilename")

        countDownTimer = object : CountDownTimer(30000, 1000) { // 1 minute duration, 1 second interval
            override fun onTick(millisUntilFinished: Long) {
                val remainingSeconds = millisUntilFinished / 1000
                timerTextView.text = "Time left: $remainingSeconds seconds"
            }

            override fun onFinish() {
                //Disables answers when game finished
                answerCard1.isClickable = false;
                answerCard2.isClickable = false;
                answerCard3.isClickable = false;
                answerCard4.isClickable = false;

                //below not necessary anymore -> finishscreen
                timerTextView.text = "Time's up!"

                //send to finishscreen with score var
                intent.putExtra("score", correctAnswers)
                startActivity(intent)
            }

        }


        countDownTimer.start()

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
        answerCard1.tag = allFlagImageIds[0]
        answerCard2.setBackgroundResource(allFlagImageIds[1])
        answerCard2.tag = allFlagImageIds[1]
        answerCard3.setBackgroundResource(allFlagImageIds[2])
        answerCard3.tag = allFlagImageIds[2]
        answerCard4.setBackgroundResource(allFlagImageIds[3])
        answerCard4.tag = allFlagImageIds[3]

        // Set one of the answer options to match the top flag image
        val correctAnswerCard = listOf(answerCard1, answerCard2, answerCard3, answerCard4).random()
        correctAnswerCard.setBackgroundResource(topFlagImageId)
        correctAnswerCard.tag = topFlagImageId

        val placeholderImage1 = findViewById<ImageView>(R.id.placeholder1)
        val placeholderImage2 = findViewById<ImageView>(R.id.placeholder2)
        val placeholderImage3 = findViewById<ImageView>(R.id.placeholder3)
        val placeholderImage4 = findViewById<ImageView>(R.id.placeholder4)
        placeholderImage1.visibility = View.VISIBLE
        placeholderImage2.visibility = View.VISIBLE
        placeholderImage3.visibility = View.VISIBLE
        placeholderImage4.visibility = View.VISIBLE

        //disable answercards spamming
        answerCard1.isClickable = true;
        answerCard2.isClickable = true;
        answerCard3.isClickable = true;
        answerCard4.isClickable = true;

    }

    private fun handleAnswerClick(selectedCard: CardView) {

        //disable answercards spamming
        answerCard1.isClickable = false;
        answerCard2.isClickable = false;
        answerCard3.isClickable = false;
        answerCard4.isClickable = false;

        // Set the background image of each option to the random flag image that was previously set
        /*answerCard1.setBackgroundResource(allFlagImageIds[0])
        answerCard2.setBackgroundResource(allFlagImageIds[1])
        answerCard3.setBackgroundResource(allFlagImageIds[2])
        answerCard4.setBackgroundResource(allFlagImageIds[3])*/

        val placeholderImage1 = findViewById<ImageView>(R.id.placeholder1)
        val placeholderImage2 = findViewById<ImageView>(R.id.placeholder2)
        val placeholderImage3 = findViewById<ImageView>(R.id.placeholder3)
        val placeholderImage4 = findViewById<ImageView>(R.id.placeholder4)
        placeholderImage1.visibility = View.GONE
        placeholderImage2.visibility = View.GONE
        placeholderImage3.visibility = View.GONE
        placeholderImage4.visibility = View.GONE

        // Check if the background resource of the selected option matches the top flag
        if (selectedCard.tag == topFlagImageId) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            correctAnswers++
            correctAnswersTextView.text = correctAnswers.toString()

        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()

        }
        Handler(Looper.getMainLooper()).postDelayed({
            setupNewGame()
        }, 1500)

    }
}
