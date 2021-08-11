package com.wu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuc006
 * @date 2019/11/14 14:43
 */
public class TestLambda {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","1","2","2");
        Set<String> set = new HashSet<>();
        list.forEach(a->set.add(a));
        System.out.println(set);
        System.out.println(set.add(null));
        System.out.println(set.contains(null));
        StringBuilder sb = new StringBuilder();
        Object o =null;
        sb.append(String.valueOf(o));
        System.out.println(sb);
    }
}
