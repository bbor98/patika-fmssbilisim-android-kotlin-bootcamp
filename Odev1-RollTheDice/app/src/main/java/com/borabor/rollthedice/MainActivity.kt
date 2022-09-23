package com.borabor.rollthedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // defining views
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing views
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)

        // executing roll function when button is clicked
        button.setOnClickListener {
            roll()
        }
    }

    private fun roll() {
        // changing image according to random generated number between 1 (inclusive) and 6 (inclusive)
        imageView.setImageResource(
            when ((1..6).random()) {
                1 -> R.drawable.ic_dice_1
                2 -> R.drawable.ic_dice_2
                3 -> R.drawable.ic_dice_3
                4 -> R.drawable.ic_dice_4
                5 -> R.drawable.ic_dice_5
                else -> R.drawable.ic_dice_6
            }
        )
    }
}