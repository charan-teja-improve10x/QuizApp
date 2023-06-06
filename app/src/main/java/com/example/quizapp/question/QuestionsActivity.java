package com.example.quizapp.question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityQuestionsBinding;

public class QuestionsActivity extends AppCompatActivity {

    private ActivityQuestionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}