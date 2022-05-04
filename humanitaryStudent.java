package com.company;

import java.util.ArrayList;

//student  humanitni

public class humanitaryStudent extends student {

    static ArrayList<Integer> humanitaryMarks = new ArrayList<Integer>();
    static int humanitaryStudents;

    public humanitaryStudent(int id, String name, String surname, int day, int month, int year) {
        super(name, surname, day, month, year);
        humanitaryStudents++;
    }

    @Override
    void studentType() {
        System.out.println("Jsem student humanitniho oboru");
    }

    // znamky studenta na humanitnim oboru
    public void mark(int addMark) {
        super.mark(addMark);
        humanitaryMarks.add(addMark);
    }

    // prumer humanitniho oboru
    public static float getHumanitaryMean() {
        total = 0;
        for (float addMark : humanitaryMarks)
            total += addMark;
        return total / (float) humanitaryMarks.size();
    }
}