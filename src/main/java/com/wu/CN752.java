package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/6/25 9:50
 */
public class CN752 {
    class Solution {
        Set<String> dead = new HashSet<>();
        Set<String> mem = new HashSet<>();
        public int openLock(String[] deadends, String target) {
            dead.addAll(Arrays.asList(deadends));
            return bfs(target);
        }

        private int dfs(String target) {
            if(mem.contains(target))return Integer.MAX_VALUE;
            mem.add(target);
            if(target.equals("0000"))return 0;

            int ret = Integer.MAX_VALUE;
            char[] ch = target.toCharArray();

            for(int i=0;i<4;i++) {
                char temp = ch[i];
                ch[i]= (char) (ch[i]-1);
                if(ch[i]<'0')ch[i]='9';
                if(!dead.contains(String.valueOf(ch))) {
                    ret = Math.min(ret, dfs(String.valueOf(ch))+1);
                }
                ch[i] = temp;
                ch[i] = (char)(ch[i]+1);
                if(ch[i]>'9')ch[i]='0';
                if(!dead.contains(String.valueOf(ch))) {
                    ret = Math.min(ret, dfs(String.valueOf(ch))+1);
                }
                ch[i] = temp;
            }
            return ret;
        }

        private int bfs(String target){
            LinkedList<String> q = new LinkedList<>();
            int ret = 0;
            q.offer(target);
            mem.add(target);
            while(!q.isEmpty()){
                int size = q.size();
                ret++;
                for(int j=0;j<size;j++){
                    String poll = q.poll();
                    if(poll.equals("0000"))return ret-1;
                    char[] ch = poll.toCharArray();
                    for(int i=0;i<4;i++) {
                        char temp = ch[i];
                        ch[i]= (char) (ch[i]-1);
                        if(ch[i]<'0')ch[i]='9';
                        if(!dead.contains(String.valueOf(ch))&&!mem.contains(String.valueOf(ch))) {
                            mem.add(String.valueOf(ch));
                            q.offer(String.valueOf(ch));
                        }
                        ch[i] = temp;
                        ch[i] = (char)(ch[i]+1);
                        if(ch[i]>'9')ch[i]='0';
                        if(!dead.contains(String.valueOf(ch))&&!mem.contains(String.valueOf(ch))) {
                            mem.add(String.valueOf(ch));
                            q.offer(String.valueOf(ch));
                        }
                        ch[i] = temp;
                    }
                }
            }
            return -1;
        }
    }



    public static void main(String[] args) {
        String[] deadends = new String[]{"8888","0101","0102","1212","2002"};
        String target = "0009";
        RunUtil.run(deadends,target);
    }
}
