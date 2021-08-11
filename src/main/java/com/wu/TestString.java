package com.wu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2019/11/22 10:39
 */
public class TestString {
    String a;
    public static void main(String[] args) {
//        Object a= null;
//        System.out.println((String)null);
//        String b = (String)null;
////        System.out.println(b.equals("b"));
//        System.out.println(new StringBuffer().toString());
//        System.out.println(1);
//        System.out.println("2019-11-09".compareTo("2019-11-21"));
//        String businessDesc ="(1)、开始时间： 2020/01/14 13:30:00, 结束时间： 2020/01/14 17:30:00, 地点： 万海, 工作事项： 开会";
//        businessDesc =businessDesc.replaceAll("^.*工作事项：\\s*","");
//        System.out.println(businessDesc);
//
//        Pattern p = Pattern.compile("(\\(\\d+\\).*?<br/>)");
//        String input = "(1)、时间： 2018/04/24 09:00:00到2018/04/24 17:30:00, 地点： 深圳南山区青青路一号青青世界酒店4楼402会议室, 工作事项： 2018年一季度新员工培训 <br/>(2)、时间： 2018/04/25 09:00:00到2018/04/25 17:30:00, 地点： 深圳南山区青青路一号青青世界酒店4楼402会议室, 工作事项： 2018年一季度新员工培训 <br/>(3)、时间： 2018/04/26 09:00:00到2018/04/26 17:30:00, 地点： 深圳南山区青青路一号青青世界酒店4楼402会议室, 工作事项： 2018年一季度新员工培训 <br/>";
//        Matcher matcher = p.matcher(input);
//        while(matcher.find()){
//        System.out.println(matcher.groupCount());
//        System.out.println(matcher.group(0));
//        }
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, 60);
//        System.out.println(cal.getTime());

        Map<Integer,TestString> map = new HashMap<>();
        ArrayList<TestString> w = new ArrayList<>();
        w.stream().map(a->{
            TestString testString = map.get(a.a);
            testString.a=a+"";
            return testString;
        }).collect(Collectors.toList());
    }
}
