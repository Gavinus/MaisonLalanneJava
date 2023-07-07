package com.example.maisonlalanne.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    static Long dateLong;
    static String dateString;

    // pour convertir une date en string en date long
    public static Long dateToLong(String date) throws Exception {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateFormated = dateFormat.parse(date);
            long epoch = dateFormated.getTime();
            System.out.println("date en long : " + epoch);
            dateLong = epoch;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateLong;
    }

    // pour convertir une date long en string
    public static String dateToString(long date) {
        dateLong = date;


        Date dateToFormat = new Date(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateString = format.format(dateToFormat);
        System.out.println("date en string : " + dateString);
        return dateString;
    }

    // le main ne sert ici qu'à tester les méthodes de la classe
    public static void main(String[] args) throws Exception {
        //dateToLong("2023-02-02T15:17:51.013+01");
        // dateToString(1675292400000L);    }}
    }
}