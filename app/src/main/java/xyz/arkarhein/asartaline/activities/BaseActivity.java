package xyz.arkarhein.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements Observer<String> {

    @Override
    public void onChanged(@Nullable String errorMsg) {
        displayErrorMsg(errorMsg);
    }

    protected void displayErrorMsg(String errorMsg) {

    }
}
