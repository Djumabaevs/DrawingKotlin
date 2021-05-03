package com.example.drawingkotlin

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.core.view.get
import com.example.drawingkotlin.databinding.ActivityMainBinding
import com.example.drawingkotlin.databinding.DialogBrushSizeBinding
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var mImageButtonCurrentPaint: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnChooser.setOnClickListener {
            ColorPickerDialog
                .Builder(this)        				// Pass Activity Instance
                .setTitle("Pick Theme")           	// Default "Choose Color"
                .setColorShape(ColorShape.SQAURE)   // Default ColorShape.CIRCLE
                .setDefaultColor(Color.GREEN)     // Pass Default Color
                .setColorListener { color, colorHex ->
                    // Handle Color Selection
                  binding.drawingView.setColor(colorHex)
                }
                .show()

            MaterialColorPickerDialog
                .Builder(this)        					// Pass Activity Instance
                .setTitle("Pick Theme")           		// Default "Choose Color"
                .setColorShape(ColorShape.SQAURE)   	// Default ColorShape.CIRCLE
                .setColorSwatch(ColorSwatch._300)   	// Default ColorSwatch._500
                .setDefaultColor(Color.BLUE) 		// Pass Default Color
                .setColorListener { color, colorHex ->
                    // Handle Color Selection
                    binding.drawingView.setColor(colorHex)
                }
                .show()
        }

        mImageButtonCurrentPaint = binding.llPaintColors[1] as ImageButton
        mImageButtonCurrentPaint!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pallet_pressed))

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

    fun paintClicked(view: View) {
        if (view !== mImageButtonCurrentPaint) {
            val imageButton = view as ImageButton
            val colorTag = imageButton.tag.toString()

            binding.drawingView.setColor(colorTag)

            imageButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pallet_pressed))

            mImageButtonCurrentPaint!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pallet_normal))
            mImageButtonCurrentPaint = view
        }
    }
}
