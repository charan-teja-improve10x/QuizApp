package com.example.quizapp.score;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}