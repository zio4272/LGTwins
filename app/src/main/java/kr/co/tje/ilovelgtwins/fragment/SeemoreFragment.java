package kr.co.tje.ilovelgtwins.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.co.tje.ilovelgtwins.LoginActivity;
import kr.co.tje.ilovelgtwins.R;
import kr.co.tje.ilovelgtwins.SignupActivity;

/**
 * Created by ziO on 2017-10-18.
 */

public class SeemoreFragment extends Fragment {

    private android.widget.TextView loginBtn;
    private TextView replyTxt;
    private TextView signupTxt;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_see_more, container, false);
        this.signupTxt = (TextView) v.findViewById(R.id.signupTxt);
        this.replyTxt = (TextView) v.findViewById(R.id.replyTxt);
        this.loginBtn = (TextView) v.findViewById(R.id.loginBtn);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvent();
        setValues();
    }

    private void setValues() {


    }

    private void setupEvent() {

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SignupActivity.class);
                startActivity(intent);

            }
        });
    }
}
