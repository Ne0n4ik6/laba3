package com.example.laba3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etFullName = findViewById(R.id.etFullName);
        EditText etClassName = findViewById(R.id.etClass);
        EditText etAge = findViewById(R.id.etAge);
        EditText etPhone = findViewById(R.id.etPhone);
        Button btnLogin = findViewById(R.id.btnLogin);
        StudentData data = StudentData.getInstance();
        etFullName.setText(data.name);
        etClassName.setText(data.className);
        etAge.setText(data.age);
        etPhone.setText(data.phone);

        btnLogin.setOnClickListener(v-> {
            data.name = etFullName.getText().toString().trim();
            data.className = etClassName.getText().toString().trim();
            data.age = etAge.getText().toString().trim();
            data.phone = etPhone.getText().toString().trim();

            boolean hasError = false;
            if (data.name.isEmpty()) {
                etFullName.setError("Введите ФИО!!!");
                hasError = true;
            }
            if (data.className.isEmpty()) {
                etClassName.setError("Введите класс!!!");
                hasError = true;
            }
            if (data.age.isEmpty()) {
                etAge.setError("Введите возраст!!!");
                hasError = true;
            }
            if (data.phone.isEmpty()) {
                etPhone.setError("Введите телефон!!!");
                hasError = true;
            }
            if (!hasError) {
                startActivity(new Intent(MainActivity.this, Screen2Activity.class));
            }
        });
    }
}