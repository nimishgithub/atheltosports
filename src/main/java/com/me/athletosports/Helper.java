package com.me.athletosports;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class Helper {
    public static Date convertToDate(Integer month, Integer day, Integer year) {
        return Date.valueOf(year + "-" + month + "-" + day);
    }

    public static Long convertDateToLong(Date date) {
        return date.getTime();
    }

    public static Date convertLongToDate(Long date) {
        return new Date(date);
    }

    public static Long convertStringDateToLong(String date) {
        return convertDateToLong(Date.valueOf(date));
    }

    public static String convertLongToFormattedString(Long date) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(convertLongToDate(date));
    }

    // close operation = JFrame.DISPOSE_ON_CLOSE
    public static void wrapInWindow(JComponent comp, int closeOeration) {
        JFrame frm = new JFrame( comp.getClass().getName() );
        frm.getContentPane().add( comp );
        frm.pack();
        frm.setDefaultCloseOperation(closeOeration);
        frm.setLocation(0, 0);
        frm.setVisible(true);
    }

    public static Long get60MonthEpochOffset() {
        return convertStringDateToLong("2020-01-01") - convertStringDateToLong("2015-01-01");
    }

    public static String getStringYear(Long epoch) {
        return convertLongToFormattedString(epoch).substring(0, 4);
    }
    
    public static Long get1MonthLong() {
        return convertStringDateToLong("2020-02-01") - convertStringDateToLong("2020-01-01");
    }

}
