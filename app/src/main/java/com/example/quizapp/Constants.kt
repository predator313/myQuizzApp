package com.example.quizapp

object Constants {
    fun getQuestion():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val q1=Question(
            1,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Cuba",
            "Chile",
            "Costa Rica",
            1
        )
        questionList.add(q1)
        val q2=Question(
            2,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "New Zealand",
            "Papu NewGuneia",
            2
        )
        questionList.add(q2)
        val q3=Question(
            3,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_belgium,
            "Green Land",
            "Poland",
            "Bulgeria",
            "Belgium",
            4
        )
        questionList.add(q3)
        val q4=Question(
            4,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Cuba",
            "Chile",
            "Peru",
            1
        )
        questionList.add(q4)
        val q5=Question(
            5,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "Fiji",
            "England",
            "Bermuda",
            2
        )
        questionList.add(q5)
        val q6=Question(
            6,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Green land",
            "Ice land",
            "Serbia",
            1
        )
        questionList.add(q6)
        val q7=Question(
            7,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_germany,
            "France",
            "Belgium",
            "Germany",
            "Spain",
            3
        )
        questionList.add(q7)
        val q8=Question(
            8,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_india,
            "India",
            "Japan",
            "Ireland",
            "Ivory Cost",
            1
        )
        questionList.add(q8)
        val q9=Question(
            9,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_kuwait,
            "Quatar",
            "UAE",
            "Kuwait",
            "Behrain",
            3
        )
        questionList.add(q9)
        val q10=Question(
            10,
            "which country this flag belongs to ?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia",
            "England",
            "France",
            "New Zealand",
            4
        )
        questionList.add(q10)
        return questionList
    }
}