package com.example.quizapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.network.QuizApi;
import com.example.quizapp.network.QuizApiService;

public class BaseActivity extends AppCompatActivity {

    protected QuizApiService quizApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createQuizApiService();
    }

    public void createQuizApiService() {
        quizApiService = new QuizApi().createQuizApiService();
    }
}
