package com.wu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wuc006
 * @date 2020/1/7 15:29
 */
public class TestReplaceAll {
    public static void main(String[] args) {
        String input="(1)、开始时间：2020-03-01 09:00:00，结束时间：2020-03-01 18:00:00，地点：1，工作事项：2<\\/br>(2)、开始时间：2020-03-05 09:00:00，结束时间：2020-03-05 18:00:00，地点：3，工作事项：1月7日消息，著名分析师郭明錤在一份报告中表示，苹果2020年即将发布的6款手机发布时间有变化，其中预计下半年将发布4款支持5G的高配版iPhone，该机或将支持6GHz mmWave。而在这之前发布<\\/br>";
        //input.replaceAll("，","<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        Pattern compile = Pattern.compile("工作事项([^\\(]+)\\(?");
        Matcher matcher = compile.matcher(input);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            System.out.println(matcher.group(1));

            matcher.appendTail(sb);
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
