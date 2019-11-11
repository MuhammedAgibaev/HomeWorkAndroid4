package com.agibaev.quizapp.history;

import android.view.View;
import com.agibaev.quizapp.R;
import com.agibaev.quizapp.core.CoreFragment;

public class HistoryFragment extends CoreFragment {

    private HistoryViewModel mViewModel;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.history_fragment;
    }

    @Override
    protected void initViewAfterCreated(View view) {

    }
}
