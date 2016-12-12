package edu.bsuir.ss.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import edu.bsuir.ss.R;
import edu.bsuir.ss.api.RestFactory;
import edu.bsuir.ss.api.login.BaseResponse;
import edu.bsuir.ss.api.login.LoginResponse;
import edu.bsuir.ss.utils.UserStorage;
import retrofit2.Call;

public class WelcomingActivity extends BaseActivity  implements View.OnClickListener{

    private Button signInButton;
    private EditText loginEdit, passEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcoming);
        initViews();
    }

    @Override
    protected void initViews() {
        loginEdit = (EditText) findViewById(R.id.loginEdit);
        passEdit = (EditText) findViewById(R.id.passEdit);
        signInButton = (Button) findViewById(R.id.signInButton);

        signInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        HashMap<String, Object> loginBody = new HashMap<>();
        loginBody.put("user_name", loginEdit.getText().toString());
        loginBody.put("password", passEdit.getText().toString());
        Call<BaseResponse<LoginResponse>> call = getClient().login(loginBody);
        enqueue(call, new RestFactory.CallbackResponse<BaseResponse<LoginResponse>>() {

            @Override
            public void result(BaseResponse<LoginResponse> data) {
                cancelProgressDialog();
                if (data != null) {

                    if (data.isSuccess()) {
                        showToastMessage(data.getMessage());
                        UserStorage.getInstance().setSessionDetails(data.getBody());
                        Intent intent = new Intent(WelcomingActivity.this, SlidingMenuActivity.class);
                        startActivity(intent);
                    } else {
                        showToastMessage(data.getMessage());
                    }
                }
            }

            @Override
            public void showProgressDialogCallback() {
                showProgressDialog();
            }
        });
    }
}
