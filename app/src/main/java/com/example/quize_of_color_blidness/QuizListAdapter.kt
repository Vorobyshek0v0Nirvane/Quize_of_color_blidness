package com.example.quize_of_color_blidness

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quize_of_color_blidness.databinding.QuizItemRecyclerRowBinding

class QuizListAdapter(private val quizModelList : List<QuizModel>) :
    RecyclerView.Adapter<QuizListAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: QuizItemRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: QuizModel){
            binding.apply {
                quixTitleText.text = model.title
                quixSubtitleText.text = model.subtitle
                quizTimeText.text = model.time + " мин"
                root.setOnClickListener {
                    val intent = Intent(root.context,QuizActivity::class.java)
                    QuizActivity.time = model.time
                    QuizActivity.questionModelList = model.questionList
                    root.context.startActivity(intent)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  binding = QuizItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return quizModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(quizModelList[position])
    }
}