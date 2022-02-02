package com.example.guessingnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var textView1 : TextView
    private lateinit var textView2 : TextView
    private lateinit var textView3 : TextView
    private lateinit var textView4 : TextView
    private lateinit var editText: EditText
    private lateinit var imageButton1: ImageButton
    private lateinit var button: Button
    private var wrong = 0
    private var point = 0

    var random: Int = nextInt(1,1000)

    fun nextStage() {
        random = nextInt(1,1000)
        editText.text.clear()
    }

    fun reset() {
        random = nextInt(1,1000)
        point = 0
        wrong = 0
        textView2.text = ""
        textView3.text = "Point: 0"
        textView4.text = "Wrong: 0"
        editText.text.clear()
    }

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
        textView3.text = "Point: 0"
        textView4.text = "Wrong: 0"

        imageButton1.setOnClickListener {
            val number: Int? = editText.text.toString().toIntOrNull()

            if(number is Int) {
                when {
                    number < random -> {
                        wrong += 1
                        textView2.text = "HINT:It's Lower!!"
                        textView3.text = "Point: $point"
                        textView4.text = "Wrong: $wrong"
                        editText.text.clear()
                    }
                    number > random -> {
                        wrong += 1
                        textView2.text = "HINT:It's Higher!!"
                        textView3.text = "Point: $point"
                        textView4.text = "Wrong: $wrong"
                        editText.text.clear()
                    }
                    else -> {
                        point += 1
                        textView2.text = "It's Correct!!"
                        textView3.text = "Point: $point"
                        textView4.text = "Wrong: $wrong"
                        editText.text.clear()
                        nextStage()
                    }
                }
            }
            else {
                wrong += 1
                Toast.makeText(this, "Please type a number!", Toast.LENGTH_SHORT).show()
                textView3.text = "Point: $point"
                textView4.text = "Wrong: $wrong"
                editText.text.clear()
            }

        }

        button.setOnClickListener {
            reset()
        }
    }
}