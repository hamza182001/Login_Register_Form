package com.example.assignment1mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    TextInputEditText Email;
    TextInputEditText Password;

    Button login;
    TextView link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        Bundle b = getIntent().getExtras();
        if (b != null) {
            String Em = b.getString("email");
            String pass = b.getString("password");

            login.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){

                    String email = Email.getText().toString();
                    String password = Password.getText().toString();

                    if (email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(Login.this, "Fields cannot be blank", Toast.LENGTH_SHORT).show();
                    } else {
                        if(email.equals(Em) && password.equals(pass)){
                            Toast.makeText(Login.this, "login successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Login.this, "login failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        } else {

            Toast.makeText(Login.this, "Login data not found", Toast.LENGTH_SHORT).show();
        }
    }


    public void init(){
        Email = findViewById(R.id.Em);
        Password = findViewById(R.id.Pass);
        login = findViewById(R.id.login);
        link = findViewById(R.id.reg);
    }
    public void OnClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}