package com.xcu.utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyTime {
    public static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    public static void main(String[] args) {
//        DateTimeFormatter df4=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(df4.format(LocalDateTime.now()));
//    }
    public static String dateToString(Date date){
        Instant instant = date.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zdt.toLocalDate();
        return df.format(localDate);
    }

    public static String DateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }
}
