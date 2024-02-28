package com.example.inchtocm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var inchInput:EditText
    private lateinit var cmInput:EditText
    private lateinit var convertButton:Button
    private lateinit var clearButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        convertButton = findViewById(R.id.convertButton)
        cmInput = findViewById(R.id.cmText)
        inchInput = findViewById(R.id.inchText)
        clearButton = findViewById(R.id.clearButton)

        convertButton.setOnClickListener{
            if (cmInput.text.isEmpty() && inchInput.text.isNotEmpty()){
                val inchtext = inchInput.text.toString()
                val answer = convert(inchtext.toFloat(),0f)
                cmInput.setText(answer.toString())
            }
            else if(inchInput.text.isEmpty() && cmInput.text.isNotEmpty()){
                val cmtext = cmInput.text.toString()
                val answer = convert(0f,cmtext.toFloat())
                inchInput.setText(answer.toString())
            }
            Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show()
        }
        clearButton.setOnClickListener{
            inchInput.setText("")
            cmInput.setText("")
        }
    }


    private fun convert(inch : Float,cm : Float) : Float{
        val result:Float = if(inch==0f){
            cm * 0.393701f
        }else{
            inch * 2.54f
        }
        return result

    }
}