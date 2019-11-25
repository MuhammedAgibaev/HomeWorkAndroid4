package com.agibaev.quizapp;

import android.app.Application;
import com.agibaev.quizapp.repository.IQuizRepository;
import com.agibaev.quizapp.repository.QuizRepository;
import com.agibaev.quizapp.repository.localDataRep.QuizLocalDataSource;
import com.agibaev.quizapp.repository.remoteDataRep.QuizRemoteDataSource;

public class App extends Application {
    public static App instance;
    public static IQuizRepository quizRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        quizRepository = new QuizRepository(new QuizRemoteDataSource(), new QuizLocalDataSource());
    }
}
