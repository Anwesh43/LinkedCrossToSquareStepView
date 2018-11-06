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
