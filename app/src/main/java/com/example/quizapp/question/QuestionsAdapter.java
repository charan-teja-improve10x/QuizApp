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
    int selectedQuestion = 1;
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
        if (selectedQuestion == position +1){
            holder.binding.questionNumberTxt.setBackgroundColor(Color.parseColor("#FFFF5722"));
            holder.binding.questionNumberTxt.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            holder.binding.questionNumberTxt.setBackgroundColor(Color.parseColor("#FF00BCD4"));
            holder.binding.questionNumberTxt.setTextColor(Color.parseColor("#FF0B0B0B"));
        }
        holder.binding.getRoot().setOnClickListener(v -> {
            onQuestionClicked.onClicked(question.getNumber());
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
