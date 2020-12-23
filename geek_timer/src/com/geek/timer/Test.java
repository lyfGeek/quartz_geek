package com.geek.timer;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author geek
 */
public class Test {

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        System.out.println(Calendar.getAvailableCalendarTypes());
//        System.out.println(Calendar.getAvailableLocales());
        Locale[] availableLocales = Calendar.getAvailableLocales();
        for (Locale availableLocale : availableLocales) {
            System.out.println("availableLocale = " + availableLocale);
        }

        TimeZone timeZone = instance.getTimeZone();
        System.out.println("timeZone = " + timeZone);
        // timeZone = sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=29,lastRule=null]
    }

}
