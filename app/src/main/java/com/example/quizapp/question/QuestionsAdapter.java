package com.example.quizapp.question;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.databinding.QuestionNumberItemBinding;
import com.example.quizapp.model.Question;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionNumberViewHolder> {

    private List<Question> questions;
    private OnQuestionClicked onQuestionClicked;
    private int selectedQuestion = 0;
    public QuestionsAdapter( List<Question> questions) {
        this.questions = questions;
    }

    void setQuestions(List<Question> questions){
        this.questions = questions;
        notifyDataSetChanged();
    }

    void setOnQuestionClicked (OnQuestionClicked onQuestionClicked) {
        this.onQuestionClicked = onQuestionClicked;
    }

    @NonNull
    @Override
    public QuestionNumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        QuestionNumberItemBinding binding = QuestionNumberItemBinding.inflate(inflater, parent, false);
        QuestionNumberViewHolder viewHolder = new QuestionNumberViewHolder(binding);
        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull QuestionNumberViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Question question = questions.get(position);
        holder.binding.questionNumberTxt.setText(String.valueOf(question.getNumber()));
        if (selectedQuestion == position){
            holder.binding.questionNumberTxt.setTextColor(Color.parseColor("#4FBEF1"));
        }else {
            holder.binding.questionNumberTxt.setTextColor(Color.parseColor("#000000"));
        }
        holder.binding.getRoot().setOnClickListener(v -> {
            onQuestionClicked.onClicked(question.getNumber());
            selectedQuestion = position;
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
