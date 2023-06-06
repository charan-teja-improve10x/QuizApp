package com.example.quizapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityHomeBinding;
import com.example.quizapp.question.QuestionsActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleStartBtn();
    }

    private void handleStartBtn() {
        binding.startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuestionsActivity.class);
            startActivity(intent);
        });
    }
}