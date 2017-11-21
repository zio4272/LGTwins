package kr.co.tje.ilovelgtwins;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tje.ilovelgtwins.data.User;
import kr.co.tje.ilovelgtwins.util.ContextUtil;
import kr.co.tje.ilovelgtwins.util.ServerUtil;

public class LoginActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.ImageView imageView;
    private android.widget.TextView signupTxt;
    private android.widget.LinearLayout loginBtnLayout;

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

        loginBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ServerUtil.login(mContext, idEdt.getText().toString(), pwEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {

                        try {
                            User u = User.getUserFromJson(json.getJSONObject("users"));
                            Toast.makeText(mContext, "로그인한 유져" + u.getUsername(), Toast.LENGTH_SHORT).show();
                            ContextUtil.login(mContext, u);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindView() {
        this.signupTxt = (TextView) findViewById(R.id.signupTxt);
        this.loginBtnLayout = (LinearLayout) findViewById(R.id.loginBtnLayout);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.imageView = (ImageView) findViewById(R.id.imageView);

    }
}
