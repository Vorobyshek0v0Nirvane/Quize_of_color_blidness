package com.example.quize_of_color_blidness

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.quize_of_color_blidness.databinding.ActivityQuizBinding
import com.example.quize_of_color_blidness.databinding.ScoreDialogBinding

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        var questionModelList: List<QuestionModel> = listOf()
        var time : String = ""
    }

    lateinit var binding: ActivityQuizBinding

    var currentQuestionIndex = 0;
    var selectedAnswer = ""
    var score = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            button1.setOnClickListener(this@QuizActivity)
            button2.setOnClickListener(this@QuizActivity)
            button3.setOnClickListener(this@QuizActivity)
            button4.setOnClickListener(this@QuizActivity)
            buttonnext.setOnClickListener(this@QuizActivity)
        }
        loadQuestions()
        startTimer()

    }

    private fun startTimer(){
        val totalTimeInMillis = time.toInt() * 60 * 1000L
        object : CountDownTimer(totalTimeInMillis, 1000L){
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished/1000
                val minutes = seconds/60
                val remainingSeconds = seconds % 60
                binding.timerIndicatorTextview.text = String.format("%02d:%02d", minutes, remainingSeconds)

            }

            override fun onFinish() {

            }

        }.start()
    }

    private fun  loadQuestions(){
        selectedAnswer = ""
        if(currentQuestionIndex == questionModelList.size){
            finishQuiz()
            return
        }
        binding.apply {
            questionIndicatorTextview.text = "Вопрос ${currentQuestionIndex+1}/ ${questionModelList.size}"
            questionProgressIndicator.progress =
                (currentQuestionIndex.toFloat() / questionModelList.size.toFloat() * 100).toInt()
            picture.setImageResource(questionModelList[currentQuestionIndex].picture)
            questionTextview.text = questionModelList[currentQuestionIndex].question
            button1.text = questionModelList[currentQuestionIndex].options[0]
            button2.text = questionModelList[currentQuestionIndex].options[1]
            button3.text = questionModelList[currentQuestionIndex].options[2]
            button4.text = questionModelList[currentQuestionIndex].options[3]
        }

    }

    override fun onClick(view: View?) {

        binding.apply {
            button1.setBackgroundColor(getColor(R.color.light_gray))
            button2.setBackgroundColor(getColor(R.color.light_gray))
            button3.setBackgroundColor(getColor(R.color.light_gray))
            button4.setBackgroundColor(getColor(R.color.light_gray))
        }

        val clickedBtn = view as Button
        if(clickedBtn.id == R.id.buttonnext){
            if(selectedAnswer == questionModelList[currentQuestionIndex].correct){
                score++
                Log.i("Счет", score.toString())
            }
            currentQuestionIndex++
            loadQuestions()
        }
        else {
            selectedAnswer = clickedBtn.text.toString()
            clickedBtn.setBackgroundColor(getColor(R.color.light_green))
        }
    }
    private fun finishQuiz() {
        val totalQuestions = questionModelList.size
        val percentage = ((score.toFloat() / totalQuestions.toFloat()) * 100).toInt()

        val dialogBinding = ScoreDialogBinding.inflate(layoutInflater)
        dialogBinding.apply {
            scoreProgressIndicator.progress = percentage
            scoreProgressText.text = "$percentage %"
            if(percentage>80){
                scoreTitle.text = "Поздравляем!" +
                        " У вас нет отклонений."
                scoreTitle.setTextColor(Color.BLACK)
            }else{
                scoreTitle.text = "По результам у Вас имеются некоторые отклонения." +
                        " Если Вы хотите узнать подробнее, пройдите следующие тесты или ознакомьтесь с теорией."
                scoreTitle.setTextColor(Color.BLACK)
            }
            scoreSubtitle.text = "$score из $totalQuestions верно"
            finishButton.setOnClickListener{
                finish()
            }
        }

        AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(false)
            .show()
    }
}