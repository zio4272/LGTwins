package kr.co.tjeit.lgtwins;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class LoginActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindView();
        setupEvent();
        setValues();

        getSupportActionBar().hide();
    }

    @Override
    public void setupEvent() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);

    }
}
