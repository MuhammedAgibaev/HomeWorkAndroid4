package com.agibaev.quizapp.main;

import android.view.View;
import android.widget.Spinner;
import com.agibaev.quizapp.R;
import com.agibaev.quizapp.core.CoreFragment;
import com.agibaev.quizapp.util.MySpinner;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainFragment extends CoreFragment {

    @BindView(R.id.spinner_category)
    Spinner spinnerCategory;
    @BindView(R.id.spinner_difficulty)
    Spinner spinnerDifficulty;

    private String[] category = {"ALL"};
    private String[] difficulty = {"ALL"};

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    protected void initViewAfterCreated(View view) {
        ButterKnife.bind(this, view);
        initCategorySpinner();
        initDifficultSpinner();
    }

    private void initCategorySpinner() {
        MySpinner.show(category, spinnerCategory, getContext());
    }

    private void initDifficultSpinner() {
        MySpinner.show(difficulty, spinnerDifficulty, getContext());
    }
}
