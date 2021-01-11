package com.wu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wuc006
 * @date 2020/9/3 15:29
 */
public class CN51 {
    class Point{
        int x;
        int y;

        public Point(int depth, int i) {
            this.x = depth;
            this.y = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    class Solution {
        List<List<String>> resultSet = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            int[][] board = new int[n][n];
            dfs(board,0,new ArrayList<>());
            return resultSet;
        }

        private void dfs(int[][] board, int depth, List<Point> points) {
            if(depth==board.length){
                resultSet.add(genResult(points,depth));
            }

            for(int i=0;i<board[0].length;i++){
                if(allChecked(points,depth,i)){
                    points.add(new Point(depth,i));
                    dfs(board,depth+1,points);
                    points.remove(points.size()-1);
                }
            }
        }

        boolean allChecked(List<Point> points,int x,int y){
            for(Point p:points) {
                if (queened(p.x,p.y,x,y))return false;
            }
            return true;
        }

        boolean queened(int queenX,int queenY,int x,int y){
            return queenX==x||queenY==y||((x-queenX)==(y-queenY))||((x-queenX)==(queenY-y));
        }

        List<String> genResult(List<Point> list,int n){
            List<String> ret = new ArrayList<>();
            StringBuilder temp= new StringBuilder(n);
            for(int i=0;i<n;i++){
                temp.append('.');
            }
            for(Point p:list){
                temp.setCharAt(p.y,'Q');
                ret.add(temp.toString());
                temp.setCharAt(p.y,'.');
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new CN51().new Solution().solveNQueens(4);
        System.out.println(lists);
    }
}
