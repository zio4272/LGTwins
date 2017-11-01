package kr.co.tje.ilovelgtwins;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import kr.co.tje.ilovelgtwins.util.ServerUtil;

public class SignupActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.EditText nameEdt;
    private android.widget.EditText phoneNumEdt;
    private android.widget.EditText emailEdt;
    private android.widget.Button okBtn;

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
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServerUtil.sign_up(mContext, idEdt.getText().toString(), pwEdt.getText().toString(), nameEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {

                    }
                });
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.emailEdt = (EditText) findViewById(R.id.emailEdt);
        this.phoneNumEdt = (EditText) findViewById(R.id.phoneNumEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
