package com.example.assignment1mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText Username;
    TextInputEditText Email;
    TextInputEditText Password;
    TextInputEditText Password2;
    Button submit;
    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                // Logic to execute when the submit button is clicked
                String username = Username.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String password2 = Password2.getText().toString();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields cannot be blank", Toast.LENGTH_SHORT).show();
                } else {
                    if (!password2.equals(password)) {
                        Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(MainActivity.this, Login.class);
                        intent.putExtra("email", email);
                        intent.putExtra("password", password);
                        startActivity(intent);
                        finish();

                    }

                }
            }
        });



    }

    public void init(){
        Username = findViewById(R.id.Username);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Password2 = findViewById(R.id.Confirm_Password);
        submit = findViewById(R.id.Sub);
        link = findViewById(R.id.link);

    }
    public void On(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

}