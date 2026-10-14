package com.example.laba3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class Screen2Fragment extends Fragment {

    private LinearLayout infoContainer;
    private LinearLayout sectionsContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen2, container, false);
        infoContainer = view.findViewById(R.id.infoContainer);
        sectionsContainer = view.findViewById(R.id.sectionsContainer);
        Button btnChoose = view.findViewById(R.id.btnChooseSections);
        Screen2FragmentArgs args = Screen2FragmentArgs.fromBundle(requireArguments());
        addRow(infoContainer, "ФИО", args.getFullName());
        addRow(infoContainer, "Класс", args.getClassName());
        addRow(infoContainer, "Возраст", args.getAge());
        addRow(infoContainer, "Телефон", args.getPhone());
        renderSections();
        btnChoose.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_screen2_to_screen3));
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        if (sectionsContainer != null) renderSections();
    }
    private void renderSections() {
        sectionsContainer.removeAllViews();
        StudentData d = StudentData.getInstance();
        if (d.selectedSection.isEmpty()) {
            TextView empty = new TextView(requireContext());
            empty.setText("Секции не выбраны");
            sectionsContainer.addView(empty);
            return;
        }
        for (String s : d.selectedSection) {
            TextView tv = new TextView(requireContext());
            tv.setText("• " + s);
            tv.setTextSize(16f);
            tv.setPadding(0, 12, 0, 12);
            sectionsContainer.addView(tv);
        }
    }
    private void addRow(LinearLayout parent, String label, String value) {
        LinearLayout row = new LinearLayout(requireContext());
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(0, 12, 0, 12);
        TextView tvLabel = new TextView(requireContext());
        tvLabel.setText(label + ": ");
        tvLabel.setWidth(90);
        row.addView(tvLabel);
        TextView tvValue = new TextView(requireContext());
        tvValue.setText(value == null || value.isEmpty() ? "—" : value);
        row.addView(tvValue);
        parent.addView(row);
    }
}