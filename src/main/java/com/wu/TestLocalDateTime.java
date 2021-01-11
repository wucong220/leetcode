package com.wu;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.UUID;

/**
 * @author wuc006
 * @date 2019/9/25 16:39
 */
public class TestLocalDateTime {
    public static void main(String[] args) {
//        String startTime = "2019-09-30 23:30:55";
//        String endTime = "2019-09-30 13:30:55";
//        LocalDateTime startDate = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        LocalDateTime endDate = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        Duration between = Duration.between(startDate, endDate);
//        System.out.println(between.toDays());
//        System.out.println(between.toHours());
//        System.out.println(between.getSeconds());
//        System.out.println(Duration.parse("P2DT3H").toDays());

//        LocalDate startDate = LocalDate.of(2019, 10, 1);
//        LocalDate endDate = LocalDate.of(2019,10,19);
//        LocalDate tempDate = startDate;
//
//        while (tempDate.isBefore(endDate.plusDays(1))){
//            String a = tempDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//            System.out.println(a);
//            tempDate=tempDate.plusDays(1);
//        }


        LocalTime first = LocalTime.parse("06:13:14");
        LocalTime last = LocalTime.parse("11:13:13");

        long attendSeconds = 0;
        LocalTime beginTime = LocalTime.parse("09:00:00");
        LocalTime endTime = LocalTime.parse("12:00:00");
        Duration bf = Duration.between(beginTime, first);
        Duration bl = Duration.between(beginTime, last);
        Duration ef = Duration.between(endTime, first);
        Duration el = Duration.between(endTime, last);

        long bfs = bf.getSeconds();
        long bls = bl.getSeconds();
        long efs = ef.getSeconds();
        long els = el.getSeconds();

        /*  b----e
         *         f----l  */ //
        if (efs > 0) { //f∈(e,+∞) 有一种情况
            attendSeconds += 0;
        } else if (efs <= 0 && bfs >= 0) {  // f∈[b,e] 有两种情况
            /*  b------e
             *       f-------l */
            if (els > 0) {  //  l∈(e,+∞)
                attendSeconds += efs;
            }
            /*  b------e
                  f--l      */
            else if (els <= 0) { // l∈(f,e]
                attendSeconds += efs - els;
            }
        } else if (bfs < 0) {  //  f∈(-∞,b)有三种情况
            /*   b----e
                f-------l  */
            if (els > 0) {      //l∈(e,+∞)
                attendSeconds += els - bls;
            }
            /*    b----e
               f-----l    */
            else if (els <= 0 && bls >= 0) {   //l∈[b,e]
                attendSeconds += bls;
            }
            /*        b---e
               f---l          */
            else if (bls < 0) {             //l∈(-∞,b)
                attendSeconds += 0;
            }
        }
        System.out.println(attendSeconds);
        System.out.println(String.format("%d:%d:%d",attendSeconds/3600,attendSeconds%3600/60,attendSeconds%60));

        System.out.println(LocalTime.MIN.minusHours(1));

        System.out.println(ChronoUnit.DAYS.between(LocalDate.of(2019,1,1),LocalDate.of(2019,10,22)));
        double dayCtr=7.5;
        System.out.println(Math.floor(dayCtr)+"天"+dayCtr%1*24+"小时");
        System.out.println(LocalDate.now().minusDays(2500));
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().withMonth(11).with(TemporalAdjusters.lastDayOfMonth()));
        LocalDate effectDate = LocalDate.parse(LocalDate.now().getYear() + "-02-28");
        if(effectDate.isBefore(LocalDate.now())) effectDate=effectDate.plusYears(1);
        System.out.println(effectDate.toString());
        System.out.println(LocalDate.now().withDayOfYear(1).toString()+"aaa");
        System.out.println(UUID.randomUUID());
        System.out.println("aabbcd".replaceAll("aa|bb","fuck"));

        System.out.println(Duration.between(LocalDateTime.of(2019,12,25,12,0,0),LocalDateTime.now()).toMinutes());
        System.out.println(UUID.randomUUID().toString());


        LocalTime startLocalTime = LocalTime.parse("09:23:08");
        LocalTime endLocalTime = LocalTime.parse("18:13:24");
        Duration overLocalTime = Duration.between(startLocalTime, endLocalTime);
        System.out.println((float)overLocalTime.getSeconds()/3600);
        System.out.println(LocalDate.now().toEpochDay());
        System.out.println(LocalDate.now().toEpochDay()-LocalDate.now().withDayOfYear(1).toEpochDay());
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfYear()).toEpochDay()-LocalDate.now().toEpochDay());
    }
}