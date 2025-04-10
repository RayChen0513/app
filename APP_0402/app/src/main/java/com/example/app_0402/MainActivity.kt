package com.example.app_0402

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edText = findViewById<EditText>(R.id.edText)
        val text = findViewById<TextView>(R.id.text)
        val group = findViewById<RadioGroup>(R.id.group)
        val submit = findViewById<Button>(R.id.submit)
        val text1 = findViewById<TextView>(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)
        val text3 = findViewById<TextView>(R.id.text3)
        val text4 = findViewById<TextView>(R.id.text4)

        submit.setOnClickListener(){
            if (edText.text.isEmpty())
            {
                edText.hint = "我的名字"
                return@setOnClickListener
            }

            val player_name = edText.text.toString()
            val computer = (0..2).random()
            val player = when(group.checkedRadioButtonId)
            {
                R.id.selection1->0
                R.id.selection2->1
                else->2
            }

            val moras = listOf("剪刀", "石頭", "布")

            if (player == 0)
            {
                if (computer == 0)
                {
                    text2.text = "贏家：平手"
                }
                else if (computer == 1)
                {
                    text2.text = "贏家：電腦"
                }
                else
                {
                    text2.text = "贏家：$player_name"
                }
            }
            else if (player == 1)
            {
                if (computer == 0)
                {
                    text2.text = "贏家：$player_name"
                }
                else if (computer == 1)
                {
                    text2.text = "贏家：平手"
                }
                else
                {
                    text2.text = "贏家：電腦"
                }
            }
            else
            {
                if (computer == 0)
                {
                    text2.text = "贏家：電腦"
                }
                else if (computer == 1)
                {
                    text2.text = "贏家：$player_name"
                }
                else
                {
                    text2.text = "贏家：平手"
                }
            }


            text1.text = player_name
            text3.text = moras[player]
            text4.text = moras[computer]

        }
    }
}