package leetCode300;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class P316 {
    static public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        //统计单词出现的频次
        for (int i = 0; i < s.length(); i++) {
            count[ch[i] - 'a']++;
            set.add(ch[i]);
        }

        int mask = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                Character top = stack.peek();
                while (top >= s.charAt(i) && count[top - 'a'] > 1&&(mask&(1<<(s.charAt(i)-'a')))==0) {
                    stack.pop();
                    mask = mask & (~(1<<(top-'a')));
                    count[top - 'a']--;
                    if (!stack.isEmpty()) top = stack.peek();
                    else break;
                }
            }
            if((mask&(1<<(s.charAt(i)-'a')))==0) {
                mask = mask | (1<<(s.charAt(i)-'a'));
                stack.push(s.charAt(i));
            }
            else{
                count[s.charAt(i)-'a']--;
            }
        }
        String collect = stack.stream().map(String::valueOf).collect(Collectors.joining(""));
        return collect.substring(0, set.size());
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bbcaac"));
    }
}
