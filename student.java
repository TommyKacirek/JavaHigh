package com.company;

import static java.util.Calendar.*;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class student {

    String name;
    String surname;
    int id = 1;
    public static int newid = 1;
    int day;
    int month;
    int year;
    float studentsMean;
    static float total = 0;
    Calendar date = Calendar.getInstance();
    static ArrayList<Integer> allMarks = new ArrayList<Integer>();
    ArrayList<Integer> marks;

    public student(String name, String surname, int day, int month, int year) {
        this.name = name;
        this.surname = surname;
        this.id = newid++;
        this.marks = new ArrayList<Integer>();
        try {
            this.date.set(year, month, day);
            this.date.getTime();
        } catch (Exception e) {
            System.out.println("Chybne datum");
        }
        System.out.println("Student pridan s id: " + this.id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    // znamky studenta
    public void mark(int addMark) {
        this.marks.add(addMark);
        allMarks.add(addMark);
    }

    public void setMean(float mean) {
        this.studentsMean = mean;
    }

    // prumer studenta
    public float getMean() {
        total = 0;
        for (float addMark : this.marks)
            total += addMark;
        this.studentsMean = total / (float) this.marks.size();
        return studentsMean;
    }

    public int getYear() {
        return date.get(YEAR);
    }

    public int getMonth() {
        return date.get(MONTH);
    }

    public int getDay() {
        return date.get(DATE);
    }

    abstract void studentType();

}