package com.example.lab_7

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TrafficLightView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val redPaint = Paint()
    private val yellowPaint = Paint()
    private val greenPaint = Paint()

    init {
        redPaint.color = Color.GRAY
        yellowPaint.color = Color.GRAY
        greenPaint.color = Color.GRAY
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = 100f

        // Отрисовка сигналов
        canvas.drawCircle(centerX, centerY - radius * 2 - 50f, radius, redPaint) // Красный сигнал
        canvas.drawCircle(centerX, centerY, radius, yellowPaint) // Желтый сигнал
        canvas.drawCircle(centerX, centerY + radius * 2 + 50f, radius, greenPaint) // Зеленый сигнал
    }

    fun setSignal(signal: Signal) {
        if (signal == Signal.RED) {
            redPaint.color = Color.RED;
        }
        if (signal == Signal.YELLOW) {
            yellowPaint.color = Color.YELLOW;
        }
        if (signal == Signal.GREEN) {
            greenPaint.color = Color.GREEN;
        }
        invalidate() // Перерисовать компонент
    }

    fun clearSignal(signal: Signal) {
        if (signal == Signal.RED) {
            redPaint.color = Color.GRAY;
        }
        if (signal == Signal.YELLOW) {
            yellowPaint.color = Color.GRAY;
        }
        if (signal == Signal.GREEN) {
            greenPaint.color = Color.GRAY;
        }
        invalidate() // Перерисовать компонент
    }
}