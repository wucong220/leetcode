package com.wu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CN5825 {
    class Solution {
        int max = Integer.MIN_VALUE;
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            int[][] score = new int[students.length][students.length];
            for (int i=0;i<students.length;i++){
                for(int j=0;j<students.length;j++){
                    int temp = 0;
                    for(int k=0;k<students[i].length;k++){
                        if(students[i][k]==mentors[j][k])temp++;
                    }
                    score[i][j] = temp;
                }
            }

            Set<Integer> mes = IntStream.range(0, mentors.length).boxed().collect(Collectors.toSet());
            dfs(students,mentors,score,0,0,mes);
            return max;
        }

        private void dfs(int[][] students, int[][] mentors, int[][] score, int sum,int i, Set<Integer> mes) {
            HashSet<Integer> set = new HashSet<>(mes);
            for (Integer me : mes) {
                set.remove(me);
                dfs(students,mentors,score,sum+score[i][me],i+1,set);
                set.add(me);
            }
            max = Math.max(sum,max);
        }
    }

    public static void main(String[] args) {
//        students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]
        RunUtil.run(RunUtil.toArray("[[1,1,0],[1,0,1],[0,0,1]]"),RunUtil.toArray("[[1,0,0],[0,0,1],[1,1,0]]"));
    }
}
