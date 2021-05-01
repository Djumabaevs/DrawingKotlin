package com.example.drawingkotlin

import android.content.Context
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet): View(context, attrs) {

    private var mDrawPath: CustomPath? = null

    internal inner class CustomPath(var color: Int, var brushThickness: Float): Path() {

    }

}