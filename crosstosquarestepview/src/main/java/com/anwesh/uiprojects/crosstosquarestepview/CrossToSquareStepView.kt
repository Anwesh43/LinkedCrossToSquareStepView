package com.anwesh.uiprojects.crosstosquarestepview

/**
 * Created by anweshmishra on 07/11/18.
 */

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.app.Activity

val nodes : Int = 5

val lines : Int = 4

val scGap : Float = 0.05f

fun Int.getInverse() : Float = 1f / this

fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.getInverse(), Math.max(0f, this - i * n.getInverse())) * n

fun Float.scaleFactor() : Float = Math.floor(this / 0.5).toFloat()

fun Float.updateScale(dir : Int) : Float = dir * scGap * (scaleFactor() + (1 - scaleFactor()) * lines.getInverse())

fun Canvas.drawCTSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val sc1 : Float = scale.divideScale(0, 2)
    val sc2 : Float = scale.divideScale(1, 2)
    val size : Float = gap/3
    paint.strokeWidth = Math.min(w, h) / 60
    paint.strokeCap = Paint.Cap.ROUND
    paint.color = Color.parseColor("#311B92")
    save()
    translate(gap * (i + 1), h / 2)
    for (j in 0..(lines - 1)) {
        val sc : Float = sc1.divideScale(i, lines)
        save()
        rotate(j * 90f)
        val x : Float = (size/2) * (2 - sc2)
        val y : Float = (size/2) * sc
        drawLine(size * sc, 0f, size, 0f, paint)
        drawLine(x, -y, x, y, paint)
        restore()
    }
    restore()
}

class CrossToSquareStepView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}