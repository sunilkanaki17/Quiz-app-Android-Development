package com.example.flagmaster


    data class questions(
        val id:Int,
        val question:String,
        val img:Int,
        val optionOne:String,
        val optionTwo:String,
        val optionThree:String,
        val optionFour:String,
        val correctAnswer:Int
    )
