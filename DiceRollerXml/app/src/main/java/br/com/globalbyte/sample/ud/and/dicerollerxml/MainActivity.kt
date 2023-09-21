package br.com.globalbyte.sample.ud.and.dicerollerxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.globalbyte.sample.ud.and.dicerollerxml.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val rollButton: Button = findViewById(R.id.roll_button)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val rollButton = binding.rollButton
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {

        val randomInt = Random.nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        binding.diceImage.setImageResource(drawableResource)

    }
}