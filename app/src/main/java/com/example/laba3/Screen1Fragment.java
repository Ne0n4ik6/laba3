package com.example.laba3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class Screen1Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen1, container, false);

        EditText etFullName = view.findViewById(R.id.etFullName);
        EditText etClassName = view.findViewById(R.id.etClass);
        EditText etAge = view.findViewById(R.id.etAge);
        EditText etPhone = view.findViewById(R.id.etPhone);
        Button btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String fullName = etFullName.getText().toString().trim();
            String className = etClassName.getText().toString().trim();
            String age = etAge.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            boolean hasError = false;
            if (fullName.isEmpty()) {
                etFullName.setError("Введите ФИО!!!");
                hasError = true;
            }
            if (className.isEmpty()) {
                etClassName.setError("Введите класс!!!");
                hasError = true;
            }
            if (age.isEmpty()) {
                etAge.setError("Введите возраст!!!");
                hasError = true;
            }
            if (phone.isEmpty()) {
                etPhone.setError("Введите телефон!!!");
                hasError = true;
            }

            if (!hasError) {
                Screen1FragmentDirections.ActionScreen1ToScreen2 action = Screen1FragmentDirections.actionScreen1ToScreen2(fullName, className, age, phone);
                Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }
}