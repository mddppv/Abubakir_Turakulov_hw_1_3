package com.example.abubakir_turakulov_hw_1_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText themeEditText;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Button btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(view -> {
            String email = emailEditText.getText().toString();
            String theme = themeEditText.getText().toString();
            String message = messageEditText.getText().toString();

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, theme);
            emailIntent.putExtra(Intent.EXTRA_TEXT, message);

            startActivity(Intent.createChooser(emailIntent, "Send message..."));
        });
    }

    private void initView() {
        emailEditText = findViewById(R.id.email);
        themeEditText = findViewById(R.id.theme);
        messageEditText = findViewById(R.id.message);
    }
}
