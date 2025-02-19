package com.example.quize_of_color_blidness


data class QuizModel(
    val id: String,
    val title: String,
    val subtitle: String,
    val time: String,
    val questionList: List<QuestionModel>
){
    constructor(): this( "", "", "", "", emptyList())
}

data class QuestionModel(
    val question: String,
    val picture: Int,
    val options: List<String>,
    val correct: String
)


data class QuestionModel_1(
    val question: String,
    val picture: Int
)