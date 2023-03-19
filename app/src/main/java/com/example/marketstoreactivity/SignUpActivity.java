package com.example.marketstoreactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.marketstoreactivity.databinding.ActivityLoginBinding;
import com.example.marketstoreactivity.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding ;
    DataBaseHelper dataBaseHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_sign_up) ;
        dataBaseHelper = new DataBaseHelper(this) ;

        binding.loginBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SignUpActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.btnCreateAcc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String firstName = binding.signUpFirstName.getText().toString() ;
                String surName = binding.signUpSurname.getText().toString() ;
                String title = binding.signUpTitle.getText().toString() ;
                String email = binding.signUpEmail.getText().toString() ;
                String password = binding.signUpPassword.getText().toString() ;
                String phone = binding.signUpPhNum.getText().toString() ;
                String town = binding.signUpTown.getText().toString() ;

                if (email.length() > 1){
                    ContentValues contentValues = new ContentValues() ;
                    contentValues.put("email" , email);
                    contentValues.put("password" , password);
                    contentValues.put("phone" , phone);
                    contentValues.put("town" , town);
                    contentValues.put("title" , title);
                    contentValues.put("surname" , surName);
                    contentValues.put("firstname" , firstName);

                    dataBaseHelper.insertUser(contentValues);
                    Toast.makeText(SignUpActivity.this , "User registered" , Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignUpActivity.this , LoginActivity.class);
                    startActivity(intent);



                }

            }
        });
    }
}