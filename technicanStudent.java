package com.company;

import java.util.ArrayList;

//student techniky

public class technicanStudent extends student {

    static int technicanStudents;
    static ArrayList<Integer> technicanMarks = new ArrayList<Integer>();

    public technicanStudent(int id, String name, String surname, int day, int month, int year) {
        super(name, surname, day, month, year);
        technicanStudents++;
    }

    @Override
    void studentType() {
        System.out.println("Jsem student techniky");
    }

    // znamky studenta techniky
    public void mark(int addMark) {
        super.mark(addMark);
        technicanMarks.add(addMark);
    }

    // prumer na technickem oboru
    public static float getTechnicanMean() {
        total = 0;
        for (float addMark : technicanMarks)
            total += addMark;
        return total / (float) technicanMarks.size();
    }
}
