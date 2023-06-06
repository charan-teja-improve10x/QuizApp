package com.example.quizapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {
    private Integer number;
    private String question;
    private List<String> answers;
    @SerializedName("correct_answer")
    private Integer correctAnswer;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
/*
 "questions": [
            {
                "number": 1,
                "question": "1 byte contains",
                "answers": [
                    "4 bits",
                    "8 bits",
                    "2 bits",
                    "16 bits"
                ],
                "correct_answer": 2
            },
            {
                "number": 2,
                "question": "Android apk stands for ",
                "answers": [
                    "Application Package",
                    "App Package Kit",
                    "App Product Kit",
                    "Application Protect"
                ],
                "correct_answer": 1
            },
            {
                "number": 3,
                "question": "Which is not a java OOPs Concept",
                "answers": [
                    "Class",
                    "Polymorphism",
                    "interface",
                    "Inheritance"
                ],
                "correct_answer": 3
            },
            {
                "number": 4,
                "question": "Which is not a java keyword",
                "answers": [
                    "public",
                    "default",
                    "static",
                    "void"
                ],
                "correct_answer": 2
            },
            {
                "number": 5,
                "question": "Which language is not used for Android app development",
                "answers": [
                    "Java",
                    "Kotlin",
                    "Both",
                    "C++"
                ],
                "correct_answer": 4
            }
        ]
    }
* */
