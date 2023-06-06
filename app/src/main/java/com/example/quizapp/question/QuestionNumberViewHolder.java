package com.example.quizapp.question;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.databinding.QuestionNumberItemBinding;

public class QuestionNumberViewHolder extends RecyclerView.ViewHolder {

    QuestionNumberItemBinding binding;

    public QuestionNumberViewHolder(QuestionNumberItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
