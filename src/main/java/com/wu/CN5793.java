package com.wu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class CN5793 {
    class Solution {
        public int nearestExit(char[][] maze, int[] entrance) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(entrance);
            TreeSet<int[]> set = new TreeSet<>((a,b)-> Arrays.toString(a).compareTo(Arrays.toString(b)));
            int ret = 0;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    int[] poll = q.poll();
                    int x = poll[0];
                    int y = poll[1];
                    if(x<0||y<0||x>maze.length-1||y>maze[x].length-1)continue;
                    else if((x==0||y==0||x==maze.length-1||y==maze[x].length-1)&&maze[x][y]=='.'&&(x!=entrance[0]||y!=entrance[1]))return ret;
                    else{
                        if(maze[x][y]=='.'){
                            int[] a = new int[]{x+1,y};
                            int[] b = new int[]{x,y+1};
                            int[] c = new int[]{x-1,y};
                            int[] d = new int[]{x,y-1};
                            if(set.add(a))q.offer(a);
                            if(set.add(b))q.offer(b);
                            if(set.add(c))q.offer(c);
                            if(set.add(d))q.offer(d);
                        }
                    }
                }
                ret++;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        char[][] maze = new char[][]{{'+','+','.','+'}, {'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = new int[]{1,2};
        RunUtil.run(maze,entrance);
    }
}
