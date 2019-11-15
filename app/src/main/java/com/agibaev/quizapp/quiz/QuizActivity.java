package com.agibaev.quizapp.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.agibaev.quizapp.R;

public class QuizActivity extends AppCompatActivity {
    private QuizViewModel mQuizViewModel;
    private TextView textView;
    public static final String ANY_DIFFICULTY = "ANY DIFFICULTY";
    public static final String ANY_CATEGORY = "ANY CATEGORY";
    public static final String SEEK_BAR = "seekbar";
    public static final String DIFF_CATEGORY = "category";
    public static final String DIFF_DIFFICULT = "difficult";

    public static void start(Context context, int seekBarValue, String categoryValue, String difficultValue){
        Intent fakeIntent = new Intent(context, QuizActivity.class);
        fakeIntent.putExtra(SEEK_BAR, seekBarValue);
        fakeIntent.putExtra(DIFF_CATEGORY, categoryValue);
        fakeIntent.putExtra(DIFF_DIFFICULT, difficultValue);
        context.startActivity(fakeIntent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
        textView = findViewById(R.id.text_toast);
        showFakeData();
    }

    private void showFakeData() {
        Intent fakeIntent = getIntent();
        int seekBar = fakeIntent.getIntExtra(SEEK_BAR, 0);
        String category = fakeIntent.getStringExtra(DIFF_CATEGORY);
        String difficulty = fakeIntent.getStringExtra(DIFF_DIFFICULT);
        Log.d("ololo", "onActivityResult: " + seekBar + " " + category + " " + difficulty);
        Toast.makeText(this, "onActivityResult: " + seekBar + "\n" + " " + category + " " + difficulty, Toast.LENGTH_SHORT).show();
        textView.setText("onActivityResult: " + seekBar + "\n" + " " + category + " " + difficulty);
    }
}
