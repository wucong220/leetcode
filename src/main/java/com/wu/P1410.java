package com.wu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wuc006
 * @date 2020/4/23 14:58
 */
public class P1410 {
    class Solution {

        public String entityParser(String text) {
            Map<String,String> map = new LinkedHashMap<>();
            map.put("&quot;","\"");
            map.put("&apos;","\'");
            map.put("&gt;",">");
            map.put("&lt;","<");
            map.put("&frasl;","/");
            map.put("&amp;","&");
            Set<Map.Entry<String, String>> entries =
                    map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                text = text.replace(entry.getKey(),entry.getValue());
            }

            return text;
        }
    }

    public static void main(String[] args) {

    }
}
