package com.agibaev.quizapp.repository;

import androidx.annotation.Nullable;
import com.agibaev.quizapp.model.Questions;
import com.agibaev.quizapp.repository.localDataRep.QuizLocalDataSource;
import com.agibaev.quizapp.repository.remoteDataRep.QuizRemoteDataSource;
import java.util.List;

public class QuizRepository implements IQuizRepository {

    @Nullable
    private QuizRemoteDataSource mRemoteDataSource;
    @Nullable
    private QuizLocalDataSource mLocalDataSource;

    public QuizRepository(@Nullable QuizRemoteDataSource remoteDataSource, @Nullable QuizLocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    @Override
    public void getQuizQuestions(int amount, Integer category, String difficulty, OnQuizCallBack questionCallBack) {
        if (mRemoteDataSource != null &&
                mLocalDataSource != null) {

            mRemoteDataSource.getQuestions(amount, category, difficulty, new OnQuizCallBack() {
                @Override
                public void onSuccess(List<Questions> quizResponse) {
                    questionCallBack.onSuccess(quizResponse);
                    mLocalDataSource.setLocalData(quizResponse);
                }

                @Override
                public void onFailure(Exception e) {
                    questionCallBack.onFailure(new Exception("ololo"));
                }
            });

            mLocalDataSource.getLocalData(questionCallBack);
        }
    }
}
