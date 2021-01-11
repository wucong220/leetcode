package com.wu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author wuc006
 * @date 2019/12/10 17:20
 */
public class P1278 {
    class Solution {
        public int palindromePartition(String s, int k) {

            return 0;
        }
    }
    public static void main(String[] args) {
        String s = LocalDateTime.now().toString();
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Date date = new Date();
        System.out.println(date);
    }
}
