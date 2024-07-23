package com.example.flagmaster

object constants {

    const val  username: String ="username"
    const val total_questions :String = "TOTAL_QUESTIONS"
    const val correctanswers :String = "CORRECTANSWERS"

    fun getquestions():ArrayList<questions>{
        val questionsList=ArrayList<questions>()


        val q1 = questions(
           1,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Kuwait",
            "Japan",
            1
        )
        questionsList.add(q1)

        val q2 = questions(
            2,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Switzerland",
            "Italy",
            2
        )

        val q3 = questions(
            3,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Algeria",
            "Afghanistan",
            "Italy",
            1
        )

        val q4 = questions(
            4,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_brazil,
            "Belgium",
            "Australia",
            "Brazil",
            "Austria",
            3
        )

        val q5 = questions(
            5,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Bulgaria",
            "Switzerland",
            "Italy",
            1
        )

        val q6 = questions(
            6,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "Australia",
            "Switzerland",
            "Fiji",
            4
        )

        val q7 = questions(
            7,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_germany,
            "Canada",
            "Australia",
            "Germany",
            "Italy",
            3

        )

        val q8 = questions(
            8,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_india,
            "India",
            "Australia",
            "Pakistan",
            "Italy",
            1
        )

        val q9 = questions(
            9,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_kuwait,
            "India",
            "Australia",
            "Kuwait",
            "Italy",
            3
        )

        val q10 = questions(
            10,"Which country does the flag belongs to?" ,
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Australia",
            "Pakistan",
            "Bangladesh",
            1
        )
        questionsList.add(q2)
        questionsList.add(q3)
        questionsList.add(q4)
        questionsList.add(q5)
        questionsList.add(q6)
        questionsList.add(q7)
        questionsList.add(q8)
        questionsList.add(q9)
        questionsList.add(q10)
        return questionsList
    }
}