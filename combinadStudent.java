package com.company;

import java.util.ArrayList;

//Kombinovany student

public class combinadStudent extends student {

    static ArrayList<Integer> combinadMarks = new ArrayList<Integer>();
    static int combinadStudents;

    public combinadStudent(int id, String name, String surname, int day, int month, int year) {
        super(name, surname, day, month, year);
        combinadStudents++;
    }

    @Override
    void studentType() {
        System.out.println("Jsem student kombinovaneho studia");
    }

    // znamky studenta kombin. studia
    public void mark(int addMark) {
        super.mark(addMark);
        combinadMarks.add(addMark);
    }

    // prumer kombin. oboru
    public static float getCombinadMean() {
        total = 0;
        for (float addMark : combinadMarks)
            total += addMark;
        return total / (float) combinadMarks.size();
    }
}