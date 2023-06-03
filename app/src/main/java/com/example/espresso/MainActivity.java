package com.example.espresso;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button submitButton;
    private TextView validationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        submitButton = findViewById(R.id.submitButton);
        validationTextView = findViewById(R.id.validationTextView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString().trim();
                if (isValidEmail(email)) {
                    validationTextView.setText("Email is valid");
                } else {
                    validationTextView.setText("Email is invalid");
                }
                validationTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    private boolean isValidEmail(String email) {
        // Add your email validation logic here
        // This is just a simple example
        return email.contains("@");
    }
}

