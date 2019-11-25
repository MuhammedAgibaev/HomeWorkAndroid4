package com.agibaev.quizapp.repository.remoteDataRep;

import com.agibaev.quizapp.repository.IQuizRepository;

public interface IQuizRemoteDataSource {

    void getQuestions(Integer amount, Integer category, String difficulty, IQuizRepository.OnQuizCallBack onQuizCallBack);
}