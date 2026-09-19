package com.example.laba3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {
    private LinearLayout infoContainer;
    private LinearLayout sectionsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        infoContainer = findViewById(R.id.infoContainer);
        sectionsContainer = findViewById(R.id.sectionsContainer);
        Button btnChoose = findViewById(R.id.btnChooseSections);

        btnChoose.setOnClickListener(v ->
            startActivity(new Intent(Screen2Activity.this, Screen3Activity.class))
        );
    }
    @Override
    protected void onResume() {
        super.onResume();
        renderInfo();
        renderSection();
    }
    private void renderInfo() {
        infoContainer.removeAllViews();
        StudentData d = StudentData.getInstance();
        addRow(infoContainer, "ФИО", d.name);
        addRow(infoContainer, "Класс", d.className);
        addRow(infoContainer, "Возраст", d.age);
        addRow(infoContainer, "Телефон", d.phone);

    }
    private void renderSection() {
        sectionsContainer.removeAllViews();
        StudentData d = StudentData.getInstance();
        if (d.selectedSection.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText("Нет выбранных секций");
            sectionsContainer.addView(empty);
            return;
        }
        for (String s : d.selectedSection) {
            TextView tvSections = new TextView(this);
            tvSections.setText("-" + s);
            tvSections.setTextSize(16f);
            tvSections.setPadding(3,6,3,6);
            sectionsContainer.addView(tvSections);
        }
    }
    private void addRow(LinearLayout parent, String label, String value) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(3,6,3,6);

        TextView tvLabel = new TextView(this);
        tvLabel.setText(label + ": ");
        row.addView(tvLabel);

        TextView tvValue = new TextView(this);
        if (value.isEmpty()) tvValue.setText("-");
        else tvValue.setText(value);
        row.addView(tvValue);

        parent.addView(row);
    }
}
