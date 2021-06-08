package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/2/26 9:20
 */
public class CN1178 {
    class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            int[] wordCodes = new int[words.length];
            for(int i=0;i<wordCodes.length;i++){
                wordCodes[i] = getCode(words[i]);
            }
            Map<Integer,Integer> map = new HashMap<>();
            for(int wordCode:wordCodes){
                map.merge(wordCode,1,Integer::sum);
            }
            List<Integer> ret = new ArrayList<>();
            for (String puzzle : puzzles) {
                int count = 0;
                for (int i = 0; i < Math.pow(2, puzzle.length() - 1); i++) {
                    int sub = 0;
                    for (int j = 0; j < puzzle.length(); j++) {
                        if (j == 0) {
                            sub = 1 << (puzzle.charAt(j) - 'a');
                        } else {
                            if (((1 << (j-1)) & i) != 0) {
                                sub |= 1 << (puzzle.charAt(j) - 'a');
                            }
                        }
                    }
                    count += map.getOrDefault(sub, 0);
                }
                ret.add(count);
            }
            return ret;
        }

        private int getCode(String word) {
            int code = 0;
            for(int j=0;j<word.length();j++){
                code = code|(1<<(word.charAt(j)-'a'));
            }
            return code;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[aaaa,asas,able,ability,actt,actor,access]"),RunUtil.toArray(
                "[aboveyz,abrodyz,abslute,absoryz,actresz,gaswxyz]"));
    }
}
