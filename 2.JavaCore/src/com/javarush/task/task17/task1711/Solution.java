package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws InterruptedException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1) / 3; i++) {
                        Thread t = new Thread(new ThreadCRUD(new String[]{"-c", args[i * 3 + 1], args[i * 3 + 2], args[i * 3 + 3]}));
                        t.start();
                        t.join();
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 0; i < (args.length - 1) / 4; i++) {
                        Thread t = new Thread(new ThreadCRUD(new String[]{"-u", args[i * 4 + 1], args[i * 4 + 2], args[i * 4 + 3], args[i * 4 + 4]}));
                        t.start();
                        t.join();
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i++) {
                        Thread t = new Thread(new ThreadCRUD(new String[]{"-d", args[i + 1]}));
                        t.start();
                        t.join();
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i++) {
                        Thread t = new Thread(new ThreadCRUD(new String[]{"-i", args[i + 1]}));
                        t.start();
                        t.join();
                    }
                    break;
                }
        }
    }

    public static class ThreadCRUD implements Runnable {

        private String argument = "";
        private String argument1 = "";
        private String argument2 = "";
        private String argument3 = "";
        private String argument4 = "";


        public ThreadCRUD(String[] args) {
            argument = args[0];
            if (args.length > 1)
                argument1 = args[1];
            if (args.length > 2)
                argument2 = args[2];
            if (args.length > 3)
                argument3 = args[3];
            if (args.length > 4)
                argument4 = args[4];
        }

        @Override
        public void run() {
            switch (argument) {
                case "-c":
                    synchronized (this) {
                        createPerson();
                        break;
                    }
                case "-u":
                    synchronized (this) {
                        updatePerson();
                        break;
                    }
                case "-d":
                    synchronized (this) {
                        deletePerson();
                        break;
                    }
                case "-i":
                    synchronized (this) {
                        infoPerson();
                        break;
                    }
            }
        }

        public void createPerson() {

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

        public void updatePerson() {

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

        public void deletePerson() {

            Person person = allPeople.get(Integer.parseInt(argument1));
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
            allPeople.set(Integer.parseInt(argument1), person);
        }

        public void infoPerson() {

            Person person = allPeople.get(Integer.parseInt(argument1));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
            String sex = "м";
            if (person.getSex() == Sex.FEMALE)
                sex = "ж";
            System.out.println(person.getName() + " " + sex + " " + sdf.format(person.getBirthDay()));

        }
    }
}
