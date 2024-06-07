package org.example.bai_case_module3.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {
    public static void main(String[] args) {
        String dateString = "2024-06-07"; // Example date string
        String dateFormatPattern = "yyyy-MM-dd"; // Example date format pattern

        // Convert the string to date
        Date date = convertStringToDate(dateString, dateFormatPattern);

        // Check and print the result
        if (date != null) {
            System.out.println("Converted Date: " + date);
        } else {
            System.out.println("Invalid date format.");
        }
    }

    public static Date convertStringToDate(String dateString, String dateFormatPattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

