package com.example.flagmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class result_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var uname : TextView = findViewById(R.id.name)
        var uscore: TextView = findViewById(R.id.score)
        var ufinish :Button = findViewById(R.id.finish_btn)

        var usernName = intent.getStringExtra("username")
        uname.text = usernName

        var totalq = intent.getIntExtra("total_questions",0)
        var correcta = intent.getIntExtra("correctanswers",0)

        uscore.text = "Your score is $correcta out of $totalq"

        ufinish.setOnClickListener {
            //
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            
        }




    }
}