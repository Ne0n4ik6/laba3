package com.example.laba3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class laba2 extends AppCompatActivity {
    private EditText firstNameEdit, secondNameEdit, thirdNameEdit;
    private LinearLayout resultLayout;
    private static final String KEY_LIST = "participants_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laba2);
        firstNameEdit = findViewById(R.id.firstNameEdit);
        secondNameEdit = findViewById(R.id.secondNameEdit);
        thirdNameEdit = findViewById(R.id.thirdNameEdit);
        Button regButton = findViewById(R.id.regButton);
        resultLayout = findViewById(R.id.resultLayout);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEdit.getText().toString().trim();
                String secondName = secondNameEdit.getText().toString().trim();
                String thirdName = thirdNameEdit.getText().toString().trim();

                boolean hasError = false;
                if (firstName.isEmpty()) {
                    firstNameEdit.setError("Введите фамилию!!!");
                    hasError = true;
                }
                if (secondName.isEmpty()) {
                    secondNameEdit.setError("Введите имя!!!");
                    hasError = true;
                }
                if (thirdName.isEmpty()) {
                    thirdNameEdit.setError("Введите отчество!!!");
                    hasError = true;
                }
                if (hasError) return;

                addRecordView(firstName + " " + secondName + " " + thirdName);

                firstNameEdit.setText("");
                secondNameEdit.setText("");
                thirdNameEdit.setText("");
            }
        });
    }

    private void addRecordView(String text) {
        TextView record = new TextView(this);
        record.setText(text);
        record.setTextSize(18f);
        record.setPadding(0, 16, 0, 16);
        resultLayout.addView(record);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultLayout.getChildCount(); i++) {
            TextView tv = (TextView) resultLayout.getChildAt(i);
            if (sb.length() > 0) sb.append("||");
            sb.append(tv.getText().toString());
        }
        outState.putString(KEY_LIST, sb.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String saved = savedInstanceState.getString(KEY_LIST, "");
        if (saved.isEmpty()) return;
        for (String item : saved.split("\\|\\|")) {
            if (!item.isEmpty()) addRecordView(item);
        }
    }
}