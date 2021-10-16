package com.example.examen.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;

import com.example.examen.R;

public class register extends AppCompatActivity {
    private EditText edit_name, edit_email, edit_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit_name = findViewById(R.id.editTextTextPersonName);
        edit_email = findViewById(R.id.editTextTextEmailAddress);
        edit_password = findViewById(R.id.editTextTextPassword);

    }

    public void RegistertoMain(View view){
        Intent intent = new Intent();
        intent.putExtra("name", edit_name.getText().toString());
        intent.putExtra("email", edit_email.getText().toString());
        intent.putExtra("password", edit_password.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}