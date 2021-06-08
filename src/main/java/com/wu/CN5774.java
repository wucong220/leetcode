package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/5/31 9:41
 */
public class CN5774 {
    class Solution {
        public int[] assignTasks(int[] servers, int[] tasks) {
            int[] ans = new int[tasks.length];
            TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(a->((int[])a)[0]).thenComparingInt(a->((int[])a)[1]).thenComparingInt(a->((int[])a)[2]));
            for (int i = 0; i < servers.length; i++) {
                int server = servers[i];
                set.add(new int[]{0, server,i});
            }
            TreeSet<int[]> ready = new TreeSet<>(Comparator.comparingInt(a->((int[])a)[1]).thenComparingInt(a->((int[])a)[2]));


            for (int i = 0; i < tasks.length; i++) {
                int task = tasks[i];
                while(!set.isEmpty()&&set.first()[0]<=i){
                    int[] server = set.pollFirst();
                    ready.add(server);
                }

                int[] server;
                if(!ready.isEmpty()){
                    server = ready.pollFirst();
                    server[0]=i+task;
                }
                else{
                    server = set.pollFirst();
                    server[0]=server[0]+task;
                }
                ans[i] = server[2];
                set.add(server);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        servers = [3,3,2], tasks = [1,2,3,2,1,2]
        System.out.println(Arrays.toString((int[]) RunUtil.run(RunUtil.toArray("[31,96,73,90,15,11,1,90,72,9,30,88]"),RunUtil.toArray("[87,10,3,5,76,74,38,64,16,64,93,95,60,79,54,26,30,44,64,71]"))));
    }
}
