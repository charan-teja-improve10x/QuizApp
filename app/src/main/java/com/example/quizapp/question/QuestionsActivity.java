package com.example.quizapp.question;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quizapp.BaseActivity;
import com.example.quizapp.R;
import com.example.quizapp.databinding.ActivityQuestionsBinding;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.score.ScoreActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsActivity extends BaseActivity implements OnQuestionClicked {

    private ActivityQuestionsBinding binding;
    private QuestionsAdapter questionsAdapter;
    private List<Quiz> quizzes = new ArrayList<>();
    private int currentQuestionNumber = 1;
    private Integer[] answerOptionIndexes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fetchQuestionsData();
        setupAdapter();
        connectAdapter();
        handlePreviousBtn();
        handleNextBtn();
        handelSubmitBtn();
        handleAnswerOptions();
    }

    private void handleNextBtn() {
        binding.nextBtn.setOnClickListener(v -> {
            currentQuestionNumber++;
            updateQuestionDetails(currentQuestionNumber);
        });
    }

    private void handlePreviousBtn() {
        binding.previousBtn.setOnClickListener(v -> {
            currentQuestionNumber--;
            updateQuestionDetails(currentQuestionNumber);
        });
    }

    private void setupAdapter() {
        questionsAdapter = new QuestionsAdapter(new ArrayList<>());
        questionsAdapter.setOnQuestionClicked(this);
    }

    private void connectAdapter() {
        binding.questionNumberRv.setAdapter(questionsAdapter);
        binding.questionNumberRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void fetchQuestionsData() {
        Call<List<Quiz>> call = quizApiService.fetchQuizItems();
        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                Toast.makeText(QuestionsActivity.this, "Fetch Success", Toast.LENGTH_SHORT).show();
                quizzes = response.body();
                questionsAdapter.setQuestions(quizzes.get(0).getQuestions());
                answerOptionIndexes = new Integer[quizzes.get(0).getQuestions().size()];
                updateQuestionDetails(1);

            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Toast.makeText(QuestionsActivity.this, "Fetch failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateQuestionDetails(int questionNumber) {
        setQuestionDetails(questionNumber);
        updateData(questionNumber);
        setPreviousBtnStyling();
        // setNextBtnStyling();
        setSubmitBtnStyling();
    }

    private void updateData(int questionNumber) {
        questionsAdapter.selectedQuestion = questionNumber;
        questionsAdapter.notifyDataSetChanged();
    }

//    private void setNextBtnStyling() {
//        if (currentQuestionNumber == quizzes.get(0).getQuestions().size()) {
//            binding.nextBtn.setEnabled(false);
//        } else {
//            binding.nextBtn.setEnabled(true);
//        }
//    }

    private void setPreviousBtnStyling() {
        if (currentQuestionNumber == 1) {
            binding.previousBtn.setEnabled(false);
        } else {
            binding.previousBtn.setEnabled(true);
        }
    }

    private void setQuestionDetails(int questionNumber) {
        currentQuestionNumber = questionNumber;
        Question question = quizzes.get(0).getQuestions().get(questionNumber - 1);
        binding.questionTxt.setText(question.getQuestion());
        binding.optionOneRb.setText(question.getAnswers().get(0));
        binding.optionTwoRb.setText(question.getAnswers().get(1));
        binding.optionThreeRb.setText(question.getAnswers().get(2));
        binding.optionFourRb.setText(question.getAnswers().get(3));
        if (answerOptionIndexes[currentQuestionNumber - 1] == -1) {
            binding.optionsRg.clearCheck();
        } else if (answerOptionIndexes[currentQuestionNumber - 1] == 0) {
            binding.optionOneRb.setChecked(true);
        } else if (answerOptionIndexes[currentQuestionNumber - 1] == 1) {
            binding.optionTwoRb.setChecked(true);
        } else if (answerOptionIndexes[currentQuestionNumber - 1] == 2) {
            binding.optionThreeRb.setChecked(true);
        } else if (answerOptionIndexes[currentQuestionNumber - 1] == 3) {
            binding.optionFourRb.setChecked(true);
        }
    }

    private void setSubmitBtnStyling() {
        if (currentQuestionNumber == quizzes.get(0).getQuestions().size()) {
            binding.submitBtn.setVisibility(View.VISIBLE);
            binding.nextBtn.setVisibility(View.GONE);
        } else {
            binding.nextBtn.setVisibility(View.VISIBLE);
            binding.submitBtn.setVisibility(View.GONE);
        }
    }

    private void handelSubmitBtn() {
        binding.submitBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, ScoreActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onClicked(int questionNumber) {
        updateQuestionDetails(questionNumber);
    }

    private void handleAnswerOptions() {
        binding.optionsRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.optionOneRb.isChecked()){
                    answerOptionIndexes[currentQuestionNumber] = 0;
                } else if (binding.optionTwoRb.isChecked()) {
                    answerOptionIndexes[currentQuestionNumber] = 1;
                } else if (binding.optionThreeRb.isChecked()) {
                    answerOptionIndexes[currentQuestionNumber] = 2;
                }else if (binding.optionFourRb.isChecked()) {
                    answerOptionIndexes[currentQuestionNumber] = 3;
                }
            }
        });
    }
}
