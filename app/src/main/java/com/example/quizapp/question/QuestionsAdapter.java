package com.example.quizapp.question;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.databinding.QuestionNumberItemBinding;
import com.example.quizapp.model.Question;

import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionNumberViewHolder> {

    private List<Question> questions;
    public QuestionsAdapter( List<Question> questions) {
        this.questions = questions;
    }

    void setQuestions(List<Question> questions){
        this.questions = questions;
        notifyDataSetChanged();
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
        Question question = questions.get(position);
        holder.binding.questionNumberTxt.setText(String.valueOf(question.getNumber()));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
