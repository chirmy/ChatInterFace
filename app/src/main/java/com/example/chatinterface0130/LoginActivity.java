package com.example.chatinterface0130;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import javax.xml.namespace.QName;

public class LoginActivity extends AppCompatActivity {

    private EditText account_edtTxt;

    private EditText password_edtTxt;

    private Button login_btn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        account_edtTxt=(EditText)findViewById(R.id.account_edtTxt);
        password_edtTxt=(EditText)findViewById(R.id.password_edtTxt);
        login_btn=(Button)findViewById(R.id.login_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String account=account_edtTxt.getText().toString();
                String password=password_edtTxt.getText().toString();
                //如果账号是admin且密码是123456，就认为登录成功
                if(account.equals("5201314")&&password.equals("rmlIloveu"))
                {
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                     finish();
                }
                else if(!account.equals("5201314")){
                    Toast.makeText(LoginActivity.this,"This account is non-existent",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"account or password are invalid",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
