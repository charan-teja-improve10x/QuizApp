package com.example.quizapp;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quizapp.model.Quiz;
import com.example.quizapp.network.QuizApi;
import com.example.quizapp.network.QuizApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getQuizQuestions() throws IOException {
        QuizApiService quizApiService = new QuizApi().createQuizApiService();
       Call<List<Quiz>> call = quizApiService.fetchQuizItems();
       List<Quiz> quizzes = call.execute().body();
       assertNotNull(quizzes);
       assertFalse(quizzes.isEmpty());
       System.out.println(new Gson().toJson(quizzes));
       System.out.println(new Gson().toJson(quizzes.get(0).getQuestions().get(3).getQuestion()));
       assertEquals("Polymorphism", quizzes.get(0).getQuestions().get(2).getAnswers().get(1));
    }
}