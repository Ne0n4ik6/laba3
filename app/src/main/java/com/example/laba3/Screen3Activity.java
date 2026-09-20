package com.example.laba3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Screen3Activity extends AppCompatActivity {
    private final List<CheckBox> checkBoxes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        CheckBox cbFootball = findViewById(R.id.cbFootball);
        CheckBox cbBasketball = findViewById(R.id.cbBasketball);
        CheckBox cbTaekwondo = findViewById(R.id.cbTaekwondo);
        CheckBox cbJudo = findViewById(R.id.cbJudo);
        CheckBox cbAthletics = findViewById(R.id.cbAthletics);
        Button btnSave = findViewById(R.id.btnSave);
        checkBoxes.add(cbFootball);
        checkBoxes.add(cbBasketball);
        checkBoxes.add(cbTaekwondo);
        checkBoxes.add(cbJudo);
        checkBoxes.add(cbAthletics);

        StudentData data = StudentData.getInstance();
        for (CheckBox cb : checkBoxes) {
            cb.setChecked(data.selectedSection.contains(cb.getText().toString()));
        }

        btnSave.setOnClickListener(v -> {
            data.selectedSection.clear();
            for (CheckBox cb : checkBoxes) {
                if (cb.isChecked())
                    data.selectedSection.add(cb.getText().toString());
            }
            startActivity(new Intent(Screen3Activity.this, Screen2Activity.class));
        });
    }
}
