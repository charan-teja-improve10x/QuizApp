package com.example.quizapp.question;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.databinding.QuestionNumberItemBinding;
import com.example.quizapp.model.Quiz;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionNumberViewHolder> {

    List<Quiz> quizzes;
    public QuestionsAdapter( List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @NonNull
    @Override
    public QuestionNumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        QuestionNumberItemBinding binding = QuestionNumberItemBinding.inflate(inflater, parent, false);
        QuestionNumberViewHolder viewHolder = new QuestionNumberViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionNumberViewHolder holder, int position) {
        Quiz quiz = quizzes.get(position);
        holder.binding.questionNumberTxt.setText(quiz.getQuestions().get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }
}
