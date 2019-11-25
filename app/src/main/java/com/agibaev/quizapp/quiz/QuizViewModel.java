package com.agibaev.quizapp.quiz;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.agibaev.quizapp.App;
import com.agibaev.quizapp.core.SingleLiveEvent;
import com.agibaev.quizapp.model.Questions;
import com.agibaev.quizapp.repository.IQuizRepository;
import java.util.List;
import static com.agibaev.quizapp.quiz.QuizActivity.CATEGORY_NAME;
import static com.agibaev.quizapp.quiz.QuizActivity.DIFF_DIFFICULT;
import static com.agibaev.quizapp.quiz.QuizActivity.SEEK_BAR;

public class QuizViewModel extends ViewModel {

    private IQuizRepository quizRepository;
    MutableLiveData<List<Questions>> questions = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();
    SingleLiveEvent<Void> finishEvent = new SingleLiveEvent<>();

    void parseIntentData(Intent fakeIntent) {
        int amount = fakeIntent.getIntExtra(SEEK_BAR, 5);
        int category = fakeIntent.getIntExtra(CATEGORY_NAME, 0);
        String difficulty = fakeIntent.getStringExtra(DIFF_DIFFICULT);
        initViews(amount, category, difficulty);
    }

    private void initViews(Integer amount, Integer category, String difficulty) {
        currentQuestionPosition.setValue(0);
        quizRepository = App.quizRepository;
        quizRepository.getQuizQuestions(amount, category, difficulty, new IQuizRepository.OnQuizCallBack() {
            @Override
            public void onSuccess(List<Questions> quizResponse) {
                if (quizResponse.size() != 0){
                    questions.setValue(quizResponse);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    void onAnswerClick(int questionPosition, int answerPosition) {

    }

    void onSkipButtonClick() {
        Integer currentPosition = currentQuestionPosition.getValue();
        if (currentPosition != null) {
            if (currentPosition == questions.getValue().size() - 1) {
                finishEvent.call();
            } else {
                currentQuestionPosition.setValue(currentPosition + 1);
            }
        }
    }

    void onPreviousQuestion(){
        if (currentQuestionPosition.getValue() >=0){
            currentQuestionPosition.setValue(currentQuestionPosition.getValue() -1);
        }else {
            finishEvent.call();
        }
    }
}
