package com.example.lab9.task_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


class HouseView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {
    private val roofPaint: Paint = Paint() // крыша
    private val tubePaint: Paint = Paint() // труба
    private val wallsPaint: Paint = Paint() // стены
    private val grassPaint: Paint = Paint() // трава
    private val skyPaint: Paint = Paint() // небо

    init {
        // Крыша
        roofPaint.color = Color.GRAY
        roofPaint.style = Paint.Style.FILL
        // Стены
        wallsPaint.color = Color.RED
        wallsPaint.style = Paint.Style.FILL
        // Труба
        tubePaint.color = Color.YELLOW
        tubePaint.style = Paint.Style.FILL
        // Земля
        grassPaint.color = Color.GREEN
        grassPaint.style = Paint.Style.FILL
        // Небо
        skyPaint.color = Color.BLUE
        skyPaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val viewWidth = width
        val viewHeight = height

        // Рисуем небо
        canvas.drawRect(
            0f,
            0f,
            viewWidth.toFloat(),
            (viewHeight / 2).toFloat(),
            skyPaint
        )

        // Рисуем траву
        canvas.drawRect(
            0f,
            (viewHeight / 2).toFloat(),
            viewWidth.toFloat(),
            viewHeight.toFloat(),
            grassPaint
        )

        // Рисуем трубу
        canvas.drawRect(
            (6 * viewWidth / 10).toFloat(),
            (0.9 * viewHeight / 5).toFloat(),
            (7 * viewWidth / 10).toFloat(),
            (2 * viewHeight / 5).toFloat(),
            tubePaint
        )

        // Рисуем крышу (треугольник)
        val roofPath = Path()
        roofPath.moveTo((viewWidth / 2).toFloat(), (viewHeight / 5).toFloat(),) // Вершина сверху
        roofPath.lineTo((9 * viewWidth / 10).toFloat(), (2 * viewHeight / 5).toFloat()) // Вершина справа
        roofPath.lineTo((1 * viewWidth / 10).toFloat(), (2 * viewHeight / 5).toFloat()) // Вершина слева
        roofPath.close() // Замыкаем треугольник
        canvas.drawPath(roofPath, roofPaint)

        // Рисуем стены (прямоугольник)
        canvas.drawRect(
            (2 * viewWidth / 10).toFloat(),
            (2 * viewHeight / 5).toFloat(),
            (8 * viewWidth / 10).toFloat(),
            (4 * viewHeight / 5).toFloat(),
            wallsPaint
        )
    }
}