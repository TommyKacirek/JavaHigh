package com.company;

import java.util.*;

public class databaze {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<student> sortedList = null;
    static TreeMap<Integer, student> databaze = new TreeMap<Integer, student>();
    static String name = null;
    static String surname = null;
    static int mark;
    static int day = 0;
    static int month = 0;
    static int year = 0;
    static int choise;
    static int id = 1;
    static int newid = 1;
    static boolean run = true;
    static student temp = null;



    public static void main(String[] args) {

        while (run) {
            System.out.println("\n---Vyber moznost---");
            System.out.println("1) Pridat nove studenty");
            System.out.println("2) Zadat studentovi znamku");
            System.out.println("3) Propusteni studenta z univerzity");
            System.out.println("4) Vypis informaci o studentovy dle ID");
            System.out.println("5) Dovednosti studenta dle ID");
            System.out.println("6) Abecedne serazeny vypis studentu");
            System.out.println("7) Spolecny prumer vsech studentu dle oboru");
            System.out.println("8) Vypis celkoveho poctu studentu dle skupiny");
            System.out.println("Jine cislo ukonci databazi");
            choise = tests.number(sc);

            switch (choise) {
                case 1:
                    System.out.println("1) Pridat nove studenty\n");
                    System.out.println(
                            "Do jake skupiny chcete priradit studenta?\n1) Do skupiny technickeho oboru\n2) Do skupiny humanitniho oboru\n3) Do skupiny kombinovaneho studia");
                    choise = tests.number(sc);

                    if (choise == 1) {
                        System.out.println("--Zadej udaje o studentovy--\nJmeno: ");
                        name = sc.next();
                        System.out.println("Prijmeni: ");
                        surname = sc.next();
                        System.out.println("--Datum narozeni-- \nZadej den např: 10 ");
                        day = tests.number(sc);
                        System.out.println("--Datum narozeni-- \nZadej mesic např: 2 ");
                        month = tests.number(sc);
                        System.out.println("--Datum narozeni-- \nZadej rok např 2000 ");
                        year = tests.number(sc);
                        if (tests.date(day, month, year) != true) {
                            System.out.println("Spatne datum");
                            continue;
                        }
                        databaze.put(newid++, new technicanStudent(id, name, surname, day, month, year));
                        break;

                    } else if (choise == 2) {
                        System.out.println("--Zadej udaje o studentovy--\nJmeno: ");
                        name = sc.next();
                        System.out.println("Prijmeni: ");
                        surname = sc.next();
                        System.out.println("--Datum narozeni-- \nZadej den např: 10 ");
                        day = tests.number(sc);
                        System.out.println("--Datum narozeni-- \nZadej mesic např: 2 ");
                        month = tests.number(sc);
                        System.out.println("--Datum narozeni-- \nZadej rok např 2000 ");
                        year = tests.number(sc);
                        if (tests.date(day, month, year) != true) {
                            System.out.println("Spatne datum");
                            continue;
                        }
                        databaze.put(newid++, new humanitaryStudent(id, name, surname, day, month, year));
                        break;

                    } else if (choise == 3) {
                       System.out.println("--Zadej udaje o studentovy--\nJmeno: ");
                        name = sc.next();
                        System.out.println("Prijmeni: ");
                        surname = sc.next();
                        System.out.println("--Datum narozeni-- \nZadej den např: 10 ");
                        day = tests.number(sc);
                        System.out.println("--Datum narozeni-- \nZadej mesic např: 2 ");
                        month = tests.number(sc);
                        System.out.println("--Datum narozeni-- \nZadej rok např 2000 ");
                        year = tests.number(sc);
                        if (tests.date(day, month, year) != true) {
                            System.out.println("Spatne datum");
                            continue;
                        }
                        databaze.put(newid++, new combinadStudent(id, name, surname, day, month, year));
                        break;
                    } else {
                        System.out.println("Nevybral jsi studijni skupinu");
                    }
                    break;

                case 2:
                    try {
                        System.out.println("2) Zadat studentovi znamku\n");
                        System.out.println("Zadej id studenta: ");
                        id = tests.number(sc);
                        System.out.println("Vloz znamku: ");
                        mark = tests.number(sc);
                        if (mark < 1 || mark > 5) {
                            System.out.println("Znamka musi byt 1 - 5 ");
                            break;
                        }
                        temp = databaze.get(id);
                        temp.mark(mark);
                    } catch (NullPointerException e) {
                        System.out.println("Student neexistuje ");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("3) Propusteni studenta z univerzity\n");
                    System.out.println("Vloz id studenta:");
                    id = tests.number(sc);
                    tests.deleteStudent(databaze.get(id));
                    databaze.remove(id);
                    break;

                case 4:
                    System.out.println("4) Vypis informaci o studentovy dle id\n");
                    System.out.println("Vloz id studenta: ");
                    id = tests.number(sc);
                    try {
                        temp = databaze.get(id);
                        System.out.println("Jmeno: " + temp.getSurname() + " " + temp.getName() + "\nRok narozeni: "
                                + temp.getYear() + " \nStudijni prumer: " + temp.getMean() + " \n");
                    } catch (NullPointerException e) {
                        System.out.println("Student neexistuje");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    System.out.println("5) Dovednosti studenta dle id\n");
                    System.out.println("Vloz id studenta: ");
                    id = tests.number(sc);
                    try {
                        temp = databaze.get(id);
                        if (temp instanceof technicanStudent) {
                            System.out.println("Jmeno: " + temp.getName() + " " + temp.getSurname() + " - "
                                    + "Technicka fakulta\nNarozen: " + temp.getDay() + "." + temp.getMonth() + "."
                                    + temp.getYear());
                            tests.leapYear(year);
                        } else if (temp instanceof humanitaryStudent) {
                            System.out.println("Jmeno: " + temp.getName() + " " + temp.getSurname() + " - "
                                    + "Humanitni fakulta\nNarozen: " + temp.getDay() + "." + temp.getMonth() + "."
                                    + temp.getYear());
                            tests.zodiac(month, day);
                        } else {
                            System.out.println("Jmeno: " + temp.getName() + " " + temp.getSurname() + " - "
                                    + "Kombinovany student\nNarozen: " + temp.getDay() + "." + temp.getMonth() + "."
                                    + temp.getYear());
                            tests.leapYear(year);
                            tests.zodiac(month, day);
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Student neexistuje");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    System.out.println("6) Vypis studentu dle prijmeni");
                    try {
                        sortedList = new ArrayList<student>(databaze.values());
                        Collections.sort(sortedList, new surname());
                        System.out.println("\nStudenti technicke falukty: ");
                        for (student student : sortedList)
                            if (student instanceof technicanStudent)
                                System.out.println("ID: " + student.getId() + ". " + student.getName() + " "
                                        + student.getSurname() + " narozen: " + student.getYear() + " prumer: "
                                        + student.getMean());
                        System.out.println("\nStudenti humanitni fakulty: ");
                        for (student student : sortedList)
                            if (student instanceof humanitaryStudent)
                                System.out.println("ID: " + student.getId() + ". " + student.getName() + " "
                                        + student.getSurname() + " narozen: " + student.getYear() + " prumer: "
                                        + student.getMean());
                        System.out.println("\nStudenti kombinovaneho studia: ");
                        for (student student : sortedList)
                            if (student instanceof combinadStudent)
                                System.out.println("ID: " + student.getId() + ". " + student.getName() + " "
                                        + student.getSurname() + " narozen: " + student.getYear() + " prumer: "
                                        + student.getMean());
                    } catch (NullPointerException e) {
                        System.out.println("V databazi neni zadny student\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 7:
                    System.out.println("7) Spolecny prumer vsech studentu dle oboru\n");
                    System.out.println(
                            "Zadej skupinu pro prumer studentu dle fakulty:\n1) Fakulta techniky \n2) Fakulta humanitni \n3) Kombinovany");
                    choise = tests.number(sc);
                    switch (choise) {
                        case 1:
                            System.out.println("Prumer na technickem oboru: " + technicanStudent.getTechnicanMean() + "\n");
                            break;
                        case 2:
                            System.out.println("Prumer na humanitnim oboru: " + humanitaryStudent.getHumanitaryMean() + "\n");
                            break;
                        case 3:
                            System.out.println("Prumer na kombinovanym oboru: " + combinadStudent.getCombinadMean() + "\n");
                            break;
                        default:
                            System.out.println("Spatna volba \n");
                            break;
                    }
                    break;

                case 8:
                    System.out.println("8) Vypis celkoveho poctu studentu dle skupiny\n");
                    System.out.println(
                            "Zadej skupinu pro pocet studentu:\n1) Fakulta techniky \n2) Fakulta humanitni \n3) Kombinovana skupina");
                    choise = tests.number(sc);
                    switch (choise) {
                        case 1:
                            System.out.println("Fakulta techniky: " + technicanStudent.technicanStudents + " studentu \n");
                            break;
                        case 2:
                            System.out.println("Fakulta humanitni: " + humanitaryStudent.humanitaryStudents + " studentu \n");
                            break;
                        case 3:
                            System.out.println("Kombinovana skupina: " + combinadStudent.combinadStudents + " studentu \n");
                            break;
                        default:
                            System.out.println("Spatna volba \n");
                            break;
                    }
                    break;


                default:
                    System.out.println("Ukonceni databaze\n");
                    run = false;
                    break;
            }
        }
    }
}
