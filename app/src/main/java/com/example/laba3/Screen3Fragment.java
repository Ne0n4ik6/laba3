package com.example.laba3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.List;

public class Screen3Fragment extends Fragment {
    private final List<CheckBox> checkBoxes = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen3, container, false);
        CheckBox cbFootball = view.findViewById(R.id.cbFootball);
        CheckBox cbBasketball = view.findViewById(R.id.cbBasketball);
        CheckBox cbTaekwondo = view.findViewById(R.id.cbTaekwondo);
        CheckBox cbJudo = view.findViewById(R.id.cbJudo);
        CheckBox cbAthletics  = view.findViewById(R.id.cbAthletics);
        Button btnSave = view.findViewById(R.id.btnSave);
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
                if (cb.isChecked()) data.selectedSection.add(cb.getText().toString());
            }
            Navigation.findNavController(requireView()).popBackStack();
        });
        return view;
    }
}