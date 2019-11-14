package com.agibaev.quizapp.data;

import com.agibaev.quizapp.model.QuizQuestions;
import java.util.List;

public interface IQuizRepository {

    void getQuizData();
    void setQuizData();


    interface OnQuizCallBack{
        void onSuccess(List<QuizQuestions> quizQuestions);
        void onFailure(Exception e);
    }
}
