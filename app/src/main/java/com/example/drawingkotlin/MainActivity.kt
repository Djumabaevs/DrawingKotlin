package com.example.drawingkotlin

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drawingkotlin.databinding.ActivityMainBinding
import com.example.drawingkotlin.databinding.DialogBrushSizeBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.drawingView.setSizeForBrush(20.toFloat())

        binding.ibBrush.setOnClickListener {
            showBrushSizeChooserDialog()
        }
    }

    private fun showBrushSizeChooserDialog() {
        var bindingBrush = DialogBrushSizeBinding.inflate(layoutInflater)
        val brushDialog = Dialog(this)
        brushDialog.setContentView(bindingBrush.root)
        brushDialog.setTitle("Brush size: ")

        val smallBtn = bindingBrush.ibSmallBrush
        smallBtn.setOnClickListener {
            binding.drawingView.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        val mediumBtn = bindingBrush.ibMediumBrush
        mediumBtn.setOnClickListener {
            binding.drawingView.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        val largeBtn = bindingBrush.ibLargeBrush
        largeBtn.setOnClickListener {
            binding.drawingView.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()

    }
}
