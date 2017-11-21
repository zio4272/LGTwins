package kr.co.tje.ilovelgtwins;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tje.ilovelgtwins.data.User;
import kr.co.tje.ilovelgtwins.util.ServerUtil;

public class SignupActivity extends BaseActivity {

    int isGender = 0;

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.EditText nameEdt;
    private android.widget.EditText phoneNumEdt;
    private android.widget.EditText emailEdt;
    private android.widget.Button okBtn;
    private android.widget.RadioButton manRadio;
    private android.widget.RadioButton womanRadio;

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

                ServerUtil.insert_user(mContext, idEdt.getText().toString(), pwEdt.getText().toString(), nameEdt.getText().toString(), isGender, phoneNumEdt.getText().toString(), emailEdt.getText().toString(), null, new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {

                        Log.d("회원가입 성공" , json.toString());

                    }
                });

            }
        });

    }

    @Override
    public void setValues() {

        if (isGender == 0) {
            manRadio.isChecked();
        } else if (isGender == 1) {
            womanRadio.isChecked();
        }

    }

    @Override
    public void bindView() {
        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.emailEdt = (EditText) findViewById(R.id.emailEdt);
        this.phoneNumEdt = (EditText) findViewById(R.id.phoneNumEdt);
        this.womanRadio = (RadioButton) findViewById(R.id.womanRadio);
        this.manRadio = (RadioButton) findViewById(R.id.manRadio);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
