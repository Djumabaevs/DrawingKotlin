package com.example.drawingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drawingkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.drawingView.setSizeForBrush(20.toFloat())
    }
}