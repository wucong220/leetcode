package com.wu;

import sun.awt.FontConfiguration;
import sun.awt.windows.WPrinterJob;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author wuc006
 * @date 2019/9/17 17:46
 */
public class testVacation {
    public static double downHalf(double input){
        double floor = Math.floor(input / 0.5);
        return floor*0.5;
    }

    public static void main(String[] args) {
        for (float i=1;i<=365;i++){
            double left=0,right=0;
            if((left=downHalf(10*i/365))>(right=downHalf(5*i/365)+downHalf(5*i/365))) {
                System.out.println(i+",left="+10*i/365+",right="+5*i/365);
            }
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Object object = null;
        format.format(object);
    }
}
