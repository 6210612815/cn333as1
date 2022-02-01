package com.example.guessingnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView1 : TextView
    lateinit var textView2 : TextView
    lateinit var textView3 : TextView
    lateinit var textView4 : TextView
    lateinit var editText: EditText
    lateinit var imageButton1: ImageButton
    lateinit var button: Button
    var count = 0
    var point = 0

    var random: Int = nextInt(1,1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        editText = findViewById(R.id.editText)
        imageButton1 = findViewById(R.id.imageButton1)
        button = findViewById(R.id.button)

        textView1.text = "Try to guess the number I'm thinking of from 1-1000!"
        textView3.text = "Point: $point"
        textView4.text = "Count: $count"

        imageButton1.setOnClickListener {
            val number: Int = editText.text.toString().toInt()

            when {
                number < random -> {
                    textView2.text = "HINT:It's Lower!!"
                    editText.text.clear()
                    count += 1
                }
                number > random -> {
                    textView2.text = "HINT:It's Higher!!"
                    editText.text.clear()
                    count += 1
                }
                else -> {
                    point += 1
                    textView2.text = "It's Correct!!"
                    textView3.text = "Point: $point"
                    textView4.text = "Count: $count"
                    editText.text.clear()
                    nextStage()
                }
            }
        }

        button.setOnClickListener {
            reset()
        }
    }

    fun nextStage() {
        random = nextInt(1,1000)
        editText.text.clear()
        count = 0
    }

    fun reset() {
        random = nextInt(1,1000)
        point = 0
        count = 0
        textView2.text = ""
        textView3.text = ""
        textView4.text = ""
        editText.text.clear()
    }
}