package com.example.dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            val resImage: ImageView = findViewById(R.id.imageView)
            val rolledNo=Dice(6).roll()
            resImage.contentDescription=rolledNo.toString()
            when(rolledNo){
                1 -> resImage.setImageResource(R.drawable.dice_1)
                2 -> resImage.setImageResource(R.drawable.dice_2)
                3 -> resImage.setImageResource(R.drawable.dice_3)
                4 -> resImage.setImageResource(R.drawable.dice_4)
                5 -> resImage.setImageResource(R.drawable.dice_5)
                6 -> resImage.setImageResource(R.drawable.dice_6)
            }
            val luckyNo = 2
            if(rolledNo==luckyNo) Toast.makeText(this,"You Win", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this,"Wrong!,Try again",Toast.LENGTH_SHORT).show()
        }
    }
}

class Dice(private val numSides: Int) {
    fun roll() = (1..numSides).random()
}