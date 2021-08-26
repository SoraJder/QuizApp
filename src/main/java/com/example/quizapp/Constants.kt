package com.example.quizapp

object Constants{

    const val USER_NAME: String= "user_name"
    const val TOTAL_QUESTIONS: String="total_question"
    const val CORRECT_ANSWERS: String= "correct_answers"

    fun getQuestions(): ArrayList<Questions>{
        val questionsList=ArrayList<Questions>()

        //1
        val que1=Questions(1,"What does this flag belong to?",
        R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",1)
        questionsList.add(que1)

        //2
        val que2=Questions(2,"What does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",2)
        questionsList.add(que2)

        //3
        val que3=Questions(3,"What does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Netherlands",
            "Germany",
            "Luxemburg",
            "Belgium",4)
        questionsList.add(que3)

        //4
        val que4=Questions(4,"What does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",3)
        questionsList.add(que4)

        //5
        val que5=Questions(5,"What does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "New Zealand",
            "Australia",
            "Tuvalu",
            "Fiji",4)
        questionsList.add(que5)

        //6
        val que6=Questions(6,"What does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Swiss",
            "Germany",
            "Poland",
            "Austria",2)
        questionsList.add(que6)

        //7
        val que7=Questions(7,"What does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India",
            "Bangladesh",
            "Nepal",
            "Indonesia",1)
        questionsList.add(que7)

        //8
        val que8=Questions(8,"What does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Saudi Arabia",
            "United Arab Emirates",
            "Kuwait",
            "Iran",3)
        questionsList.add(que8)

        //9
        val que9=Questions(9,"What does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Colombia",
            "Portugal",
            "Bolivia",1)
        questionsList.add(que9)

        //10
        val que10=Questions(10,"What does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Tuvalu",
            "Australia",
            "Fiji",
            "New Zealand",4)
        questionsList.add(que10)

        return questionsList
    }
}