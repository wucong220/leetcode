package com.wu;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2021/3/30 17:00
 */
public class CN1807 {
    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> collect = knowledge.stream().collect(Collectors.toMap(a -> a.get(0), a -> a.get(1)));
            Pattern p = Pattern.compile("\\(([^()]+)\\)");
            Matcher matcher = p.matcher(s);
            StringBuffer sb = new StringBuffer();
            while(matcher.find()){
                String group = matcher.group(1);
                matcher.appendReplacement(sb,collect.getOrDefault(group,"?"));
            }
            matcher.appendTail(sb);
            return sb.toString();
        }
    }
}
