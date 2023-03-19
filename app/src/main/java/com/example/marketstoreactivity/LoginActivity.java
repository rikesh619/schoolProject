package com.example.marketstoreactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.marketstoreactivity.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding ;
    DataBaseHelper dataBaseHelper ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_login) ;
        dataBaseHelper = new DataBaseHelper(this) ;


        binding.signUpBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this , SignUpActivity.class);
                startActivity(intent);
            }
        });

        binding.btnSignIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String email = binding.email.getText().toString() ;
                String password = binding.password.getText().toString() ;

                if (dataBaseHelper.isLoginValid(email , password)){

                    Intent intent =  new Intent(LoginActivity.this , DashboardActivity.class) ;
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this , "Login Successful" , Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this , "Invalid Email or Password  " , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}