package com.wu;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static boolean checkTimeIsOfTimeRange(String checkTime, String strTimeRage) {
        String tempTime = checkTime.split(" ")[1];
        String[] arrayTimeRage = strTimeRage.split("-");
        if (tempTime.compareTo(arrayTimeRage[0]) >= 0 & tempTime.compareTo(arrayTimeRage[1]) <= 0) {
            return true;
        }
        return false;
    }

    private static void test(){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Calendar calendar = Calendar.getInstance();
        System.out.println("当天"+format.format(calendar.getTime()));//当天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("当月第一天"+format.format(calendar.getTime()));//当月第一天

         calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,0);//上月最后一天
        System.out.println("上月最后一天"+format.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_MONTH,1);//上月第一天
        System.out.println("上月第一天"+format.format(calendar.getTime()));


        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,0);//上个月的最后一天
        System.out.println("上个月的最后一天"+format.format(calendar.getTime()));
        calendar.add(Calendar.MONTH,-2);
        calendar.set(Calendar.DAY_OF_MONTH,1);//上三个月的第一天
        System.out.println("上三个月的第一天："+format.format(calendar.getTime()));
    }

    public static void main(String[] args) {
	// write your code here
        String checkTime = "2019-07-29 18:16:22";
        String strTimeRage = "17:30:00-23:59:59";
        System.out.println(checkTimeIsOfTimeRange(checkTime,strTimeRage));

        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;
        // 获取前月的第一天
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime());
        System.out.println("本月第一天和最后一天分别是 ： " + firstday + " and " + lastday);

        Calendar calendar = Calendar.getInstance();
        System.out.println(format.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        System.out.println(format.format(calendar.getTime()));
        calendar.add(Calendar.MONTH,-1);
        System.out.println(format.format(calendar.getTime()));

        test();
    }
}
