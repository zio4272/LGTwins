package kr.co.tje.ilovelgtwins;

import android.os.Bundle;
import android.widget.EditText;

public class SignupActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.EditText nameEdt;
    private android.widget.EditText phoneNumEdt;
    private android.widget.EditText emailEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        bindView();
        setupEvent();
        setValues();
    }

    @Override
    public void setupEvent() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        this.emailEdt = (EditText) findViewById(R.id.emailEdt);
        this.phoneNumEdt = (EditText) findViewById(R.id.phoneNumEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);

    }
}
