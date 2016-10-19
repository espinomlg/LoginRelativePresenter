package com.example.espino.loginrelative;


import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LoginRelative extends AppCompatActivity implements IloginMVP.View{

    private IloginMVP.Presenter loginMVP;
    private EditText edtPwd;
    private EditText edtUser;
    private TextInputLayout txiUser;
    private TextInputLayout txiPwd;
    private Button btnOk;
    private CheckBox chkRemenber;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative);
        loginMVP = new LoginPresenter(this);
        edtUser = (EditText)findViewById(R.id.editUser);
        edtPwd = (EditText)findViewById(R.id.editPasswd);
        btnOk = (Button)findViewById(R.id.btnOK);
        txiUser = (TextInputLayout)findViewById(R.id.in1);
        txiPwd = (TextInputLayout)findViewById(R.id.in2);


        edtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txiUser.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        edtPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txiPwd.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginMVP.validateCredentials(edtPwd.getText().toString(), edtUser.getText().toString());
            }
        });

        if(((LoginApplication)getApplicationContext()).getUser() != null){
            Log.d(TAG,((LoginApplication)getApplicationContext()).getUser().toString());
        }


    }

    @Override
    public void setMessage(String msg, int idView) {

        switch (idView){
            case R.id.editUser:
                txiUser.setError(msg);
                edtUser.requestFocus();
                break;
            case  R.id.editPasswd:
                txiPwd.setError(msg);
                edtPwd.requestFocus();
                break;
            default:
                Toast.makeText(LoginRelative.this, R.string.ok, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(((LoginApplication)getApplicationContext()).getUser() != null){
            Log.d(TAG,((LoginApplication)getApplicationContext()).getUser().toString());

        }

    }
}