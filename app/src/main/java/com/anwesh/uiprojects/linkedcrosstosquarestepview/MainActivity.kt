package com.anwesh.uiprojects.linkedcrosstosquarestepview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.crosstosquarestepview.CrossToSquareStepView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CrossToSquareStepView.create(this)
    }
}
