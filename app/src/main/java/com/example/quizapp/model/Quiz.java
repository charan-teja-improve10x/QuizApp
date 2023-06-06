package com.example.quizapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quiz {
    @SerializedName("_id")
    private String quizId;
    private Module module;
    private List<Question> questions;

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}

//[
//        {
//        "_id": "647ec79f456f2b03e80bb62e",
//
//        "questions": [
//        {
//        "number": 1,
//        "question": "1 byte contains",
//        "answers": [
//        "4 bits",
//        "8 bits",
//        "2 bits",
//        "16 bits"
//        ],
//        "correct_answer": 2
//        },
//        {
//        "number": 2,
//        "question": "Android apk stands for ",
//        "answers": [
//        "Application Package",
//        "App Package Kit",
//        "App Product Kit",
//        "Application Protect"
//        ],
//        "correct_answer": 1
//        },
//        {
//        "number": 3,
//        "question": "Which is not a java OOPs Concept",
//        "answers": [
//        "Class",
//        "Polymorphism",
//        "interface",
//        "Inheritance"
//        ],
//        "correct_answer": 3
//        },
//        {
//        "number": 4,
//        "question": "Which is not a java keyword",
//        "answers": [
//        "public",
//        "default",
//        "static",
//        "void"
//        ],
//        "correct_answer": 2
//        },
//        {
//        "number": 5,
//        "question": "Which language is not used for Android app development",
//        "answers": [
//        "Java",
//        "Kotlin",
//        "Both",
//        "C++"
//        ],
//        "correct_answer": 4
//        }
//        ]
//        }
//        ]
