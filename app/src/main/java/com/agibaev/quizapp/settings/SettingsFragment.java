package com.agibaev.quizapp.settings;

import android.view.View;

import com.agibaev.quizapp.R;
import com.agibaev.quizapp.core.CoreFragment;

public class SettingsFragment extends CoreFragment {
    private SettingsViewModel mViewModel;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    protected void initViewAfterCreated(View view) {

    }
}
