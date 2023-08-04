package com.example.rockpaperscissorsgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import com.example.rockpaperscissorsgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rock.setOnClickListener {
            rollPict()
        }

        binding.scissors.setOnClickListener {
            rollPict()
        }

        binding.paper.setOnClickListener {
            rollPict()
        }
    }

    private fun rollPict() {
        val pict = Random(3)
        val pictRoll = pict.inlineRoll()
        val enemy: ImageView = binding.pictEnemy

        val drawableResources = when (pictRoll) {
            1 -> R.drawable.rock
            2 -> R.drawable.scissors
            else -> R.drawable.paper
        }
        enemy.setImageResource(drawableResources)

        val animation = ScaleAnimation(
            0.75f, 1.5f, 0.75f, 1.5f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        animation.duration = 200
        animation.repeatMode = Animation.REVERSE
        enemy.startAnimation(animation)
    }
}

class Random(private val option: Int) {
    private fun roll(): Int {
        return (1..option).random()
    }

    fun inlineRoll(): Int {
        return roll()
    }
}