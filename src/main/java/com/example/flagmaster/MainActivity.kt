package com.example.flagmaster

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        val btn_start : Button = findViewById(R.id.btn_start)
        val name : EditText = findViewById(R.id.et_name)

        btn_start.setOnClickListener {

            if(name.text.isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent= Intent(this,questionslistActivity::class.java)
                intent.putExtra("username",name.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}