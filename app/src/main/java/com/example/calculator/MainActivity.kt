package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buNumberEvent(view: View) {
        if (isNewop){
            etShowNumber.setText("")
        }
        isNewop = false
        val buSelect = view as Button
        var buClickValue:String = etShowNumber.text.toString()
        when(buSelect.id){
            bu0.id -> {
                buClickValue += "0"
            }
            bu1.id -> {
               buClickValue += "1"
            }
            bu2.id -> {
                buClickValue += "2"
            }
            bu3.id -> {
                buClickValue += "3"
            }
            bu4.id -> {
                buClickValue += "4"
            }
            bu5.id -> {
                buClickValue += "5"
            }
            bu6.id -> {
                buClickValue += "6"
            }
            bu7.id -> {
                buClickValue += "7"
            }
            bu8.id -> {
                buClickValue += "8"
            }
            bu9.id -> {
                buClickValue += "9"
            }
            buDot.id -> {
                buClickValue += "."
            }
            buPlusMins.id -> {
                buClickValue = "-" + buClickValue
            }
        }
        etShowNumber.setText(buClickValue)
    }
    var op = "*"
    var oldNumber = ""
    var isNewop = true
    fun buOpEvent(view: View){
        val buSelect = view as Button
        when(buSelect.id){
            buMul.id -> {
                op = "*"
            }
            buSub.id -> {
                op = "-"
            }
            buSum.id -> {
                op = "+"
            }
            buDiv.id -> {
                op = "/"
            }
        }
        oldNumber = etShowNumber.text.toString()
        isNewop = true
    }
    fun buEqualEvent(view: View){
        val NewNumber = etShowNumber.text.toString()
        var finalNumber:Double ?= null
        when(op){
            "*" -> {
                finalNumber = oldNumber.toDouble() * NewNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - NewNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + NewNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / NewNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewop = true
    }
    fun buPercent(view: View){
        val number:Double = etShowNumber.text.toString().toDouble()/100
        etShowNumber.setText(number.toString())
        isNewop = true
    }
    fun buClean(view: View){
        etShowNumber.setText("0")
        isNewop = true
    }
}
