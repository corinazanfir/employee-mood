package com.team4.employeemood;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse("16/01/1988");
        Date hireDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2019");

        Employee employee1 = new Employee("Catalin", "Gheorghe", birthday, hireDate);

        System.out.println(employee1);

        Mood mood = new Mood(5, "iiiii", "not much", "zero", new Date(), "catalin.gheorghe@domain.com");

        for (Mood m : MoodData.moodList) {
            System.out.println(m.dayRating);
        }

        MoodData md = new MoodData();

        md.readMoodDataFromFile("MoodSampleFile.csv");



        for(Mood m:MoodData.moodList){

            System.out.println(m);

        }


    }
}
