package com.example.quize_of_color_blidness

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quize_of_color_blidness.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quizModelList: MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizModelList = mutableListOf()
        getDataFromFirebase()
    }
    class CustomDialogFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder = AlertDialog.Builder(activity)
            return builder.setTitle("Инструкция")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(R.layout.dialog)
                .setPositiveButton("OK", null)
                .create()
        }
    }

    fun showDialog(v: View) {
        val dialog = CustomDialogFragment()
        dialog.show(supportFragmentManager, "custom")
    }

    private fun setupRecyclerView(){
        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

    private fun getDataFromFirebase(){
        val listQuestionModel_2 = listOf(
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_1, listOf("12", "22", "13", "ничего"), "12"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_2, listOf("21", "84", "74", "ничего"), "74"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_3, listOf("3", "6", "8", "ничего"), "6"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_4, listOf("44", "22", "42", "ничего"), "42"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_5, listOf("5", "2", "8", "ничего"), "2"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_6, listOf("27", "2", "17", "ничего"), "27"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_7, listOf("5", "2", "3", "ничего"), "2"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_8, listOf("зеленые и оранжевые точки", "оранжевые точки", "зеленые точки", "ничего"), "зеленые и оранжевые точки"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_9, listOf("6", "8", "просто точки", "ничего"), "6"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_10, listOf("зеленые точки", "красные точки", "зеленые и красные точки", "ничего"), "зеленые и красные точки")
        )
        val listQuestionModel_1 = listOf(
            QuestionModel("Сколько оттенков(цветов) Вы видите на картинке?", R.drawable.picture_77, listOf("менее 20", "от 20 до 32", "от 32 до 39", "более 39"), "от 32 до 39")
        )
        val listQuestionModel_3 = listOf(
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_21, listOf("круг и треугольник", "круг", "треугольник", "ничего"), "круг и треугольник"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_22, listOf("3", "5", "9", "ничего"), "5"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_23, listOf("круг", "треугольник", "9", "ничего"), "треугольник"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_24, listOf("13", "3", "6", "ничего"), "13"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_25, listOf("треугольник", "круг", "круг и треугольник", "ничего"), "круг и треугольник"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_26, listOf("9", "96", "6", "ничего"), "96"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_27, listOf("6", "круг", "5", "ничего"), "5"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_28, listOf("8", "9", "6", "ничего"), "9"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_29, listOf("88", "66", "136", "ничего"), "136"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_210, listOf("круг и треугольник", "9", "круг", "ничего"), "круг и треугольник"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_211, listOf("12", "2", "7", "ничего"), "12"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_213, listOf("96", "9", "6", "ничего"), "96"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_212, listOf("круг и треугольник", "треугольник", "круг", "ничего"), "круг и треугольник"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_215, listOf("круг", "треугольник", "круг и треугольник", "ничего"), "круг и треугольник"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_216, listOf("6", "9", "66", "ничего"), "66"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_214, listOf("треугольник", "круг", "круг и треугольник", "ничего"), "круг и треугольник"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_217, listOf("36", "9", "6", "ничего"), "36"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_218, listOf("41", "7", "14", "ничего"), "14"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_219, listOf("8", "9", "круг", "ничего"), "9"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_220, listOf("1", "8", "4", "ничего"), "4"),
            QuestionModel("Что Вы видите на картинке?", R.drawable.picture_221, listOf("1", "13", "3", "ничего"), "13")
        )
        val listQuizModel_4 = listOf(
            QuestionModel("Посмотрите на линии рядом с центром. Что Вы видите?",R.drawable.picture_99, listOf("Все линии находятся на одинаковом расстоянии друг от друга и имеют одинаковый цвет", "Некоторые линии темнее других", "Линии по горизонтале расположены ближе друг к другу, а по вертикале - дальше друг от друга", "Не могу понять, что я вижу"), "Все линии находятся на одинаковом расстоянии друг от друга и имеют одинаковый цвет")
        )






        quizModelList.add(QuizModel("1", "Тест с цветной палитрой", "Распознавание разных оттенков", "10", listQuestionModel_1))
        quizModelList.add(QuizModel("2", "Тест Ишихара_короткий", "Тест на дальтонизм с пластинами Ишихара", "2", listQuestionModel_2))
        quizModelList.add(QuizModel("3", "Тест Ишихара_расширенный", "Тест на дальтонизм с пластинами Ишихара", "7", listQuestionModel_3))
        quizModelList.add(QuizModel("4", "Тест на Астигматизм_без доп. обработки", "Тест на выявление астигматизма", "15", listQuizModel_4))
//        quizModelList.add(QuizModel("5", "Тест на Миопию", "Тест на выявление миопии", "20"))
//        quizModelList.add(QuizModel("6", "Тест на Гиперметропию", "Тест на выявление гиперметропии", "10"))
//        quizModelList.add(QuizModel("7", "Тест на бинокулярное зрение", "Тест на выявление бинокулярного зрения", "25"))
//        quizModelList.add(QuizModel("8", "Гимнастика для глаз", "Комплекс гимнастик для глаз", "15"))

        setupRecyclerView()
    }
}