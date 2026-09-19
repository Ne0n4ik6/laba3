package com.example.laba3;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
    public static StudentData instance;
    public String name = "";
    public String className = "";
    public String age = "";
    public String phone = "";
    public final List<String> selectedSection = new ArrayList<>();
    public static final String[] allSection = {"Футбол", "Баскетбол", "Тэквандо", "Дзюдо", "Атлетика"};
    private StudentData() {};
    public static StudentData getInstance() {
        if (instance == null) instance = new StudentData();
        return instance;
    }
}
