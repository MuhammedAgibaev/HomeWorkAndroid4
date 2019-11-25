package com.agibaev.quizapp.repository;


import com.agibaev.quizapp.model.Questions;
import java.util.List;

public interface IQuizRepository {

    void getQuizQuestions(int amount, Integer category, String difficult, OnQuizCallBack questionCallBack);

    interface OnQuizCallBack {

        void onSuccess(List<Questions> result);

        void onFailure(Exception e);
    }
}
