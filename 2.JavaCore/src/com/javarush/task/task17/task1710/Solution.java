package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static String argument1;
    public static String argument2;
    public static String argument3;
    public static String argument4;

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length > 1)
            argument1 = args[1];
        if (args.length > 2)
            argument2 = args[2];
        if (args.length > 3)
            argument3 = args[3];
        if (args.length > 4)
            argument4 = args[4];

        switch (args[0]) {
            case "-c": createPerson(); break;
            case "-u": updatePerson(); break;
            case "-d": deletePerson(); break;
            case "-i": infoPerson(); break;
        }

    }

    public static void createPerson() throws ParseException {

        Person person;
        String name = argument1;
        int days = Integer.parseInt(argument3.substring(0, 2));
        int months = Integer.parseInt(argument3.substring(3, 5)) - 1;
        int years = Integer.parseInt(argument3.substring(6)) - 1900;
        Date date = new Date(years, months, days);
        if (argument2.equals("м")) {
            person = Person.createMale(name, date);
        } else {
            person = Person.createFemale(name, date);
        }
        allPeople.add(person);

        System.out.println(allPeople.indexOf(person));
    }

    public static void updatePerson() {

        Person person = allPeople.get(Integer.parseInt(argument1));
        person.setName(argument2);
        person.setSex((argument3.equals("м")) ? Sex.MALE : Sex.FEMALE);
        int days = Integer.parseInt(argument4.substring(0, 2));
        int months = Integer.parseInt(argument4.substring(3, 5)) - 1;
        int years = Integer.parseInt(argument4.substring(6)) - 1900;
        Date date = new Date(years, months, days);
        person.setBirthDay(date);
        allPeople.set(Integer.parseInt(argument1), person);
    }

    public static void deletePerson() {

        Person person = allPeople.get(Integer.parseInt(argument1));
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
        allPeople.set(Integer.parseInt(argument1), person);
    }

    public static void infoPerson() {

        Person person = allPeople.get(Integer.parseInt(argument1));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        String sex = "м";
        if (person.getSex() == Sex.FEMALE)
            sex = "ж";
        System.out.println(person.getName() + " " + sex + " " + sdf.format(person.getBirthDay()));

    }
}
