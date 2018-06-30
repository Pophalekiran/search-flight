package com.example.flightnetwork.searchflights.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class StringUtil {

    private StringUtil() {
    }

    public static Date parseDate(String date) throws ParseException {
        SimpleDateFormat formatter =null;
        if(date.contains("-")){
            formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        }else if(date.contains("/")){
            formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        }
        TimeZone istTimeZone = TimeZone.getTimeZone("GMT");
        formatter.setTimeZone(istTimeZone);
        return formatter.parse(date);
    }

    public static String[] parseString(String s){
        String s1[]=  null;
        if (s.contains("|")) {
            s1 = s.split("\\|");
        }
        return s1;
    }
}
