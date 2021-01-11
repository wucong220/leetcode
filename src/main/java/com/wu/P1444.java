package com.wu;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuc006
 * @date 2020/5/11 15:27
 */
public class P1444 {

    class Solution {
        public int ways(String[] pizza, int k) {
            int save[][][] = new int[k][pizza[0].length()][pizza.length];
            boolean saved[][][] = new boolean[k][pizza[0].length()][pizza.length];
            long[] pizzaX = new long[pizza.length];
            long[] pizzaY = new long[pizza[0].length()];
            int row = pizza.length - 1;
            int column = pizza[0].length() - 1;
            for (int i = 0; i < pizza.length; i++) {
                String s = pizza[i];
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == 'A') {
                        pizzaX[i] |= 1L << j;
                        pizzaY[j] |= 1L << i;
                    }
                }
            }
            return ways(pizzaX, pizzaY, k - 1, 0, 0, row, column,save,saved);
        }

        public int ways(long[] pizzaX, long[] pizzaY, int k, int x1, int y1, int row, int column, int[][][] save, boolean[][][] saved) {
            if(saved[k][x1][y1]){
                return save[k][x1][y1];
            }
            int way = 0;
            long l = 0xFFFF_FFFF_FFFF_FFFFL;
            long xMask = l << x1;
            long yMask = l << y1;

            long app = 0;
            //not able to cut.
            if (k == 0) {
                for (int i = y1; i <= row; i++) {
                    app = pizzaX[i] & xMask | app;
                }
                if (app != 0) {
                    return 1;
                } else {
                    return 0;
                }
            }

            //cut vertical
            app = 0;
            for (int i = y1; i < row; i++) {
                app = pizzaX[i] & xMask | app;
                if (app != 0) {
                    way += ways(pizzaX, pizzaY, k - 1, x1, i + 1, row, column, save, saved)%1000_000_007;
                    way %=1000_000_007;
                }
            }

            //cut horizontal
            app = 0;
            for (int i = x1; i < column; i++) {
                app = pizzaY[i] & yMask | app;
                if (app != 0) {
                    way += ways(pizzaX, pizzaY, k - 1, i + 1, y1, row, column, save, saved)%1000_000_007;
                    way %=1000_000_007;
                }
            }
            way %=1000_000_007;
            saved[k][x1][y1]=true;
            save[k][x1][y1]=way;
            return way;
        }
    }

    public static void main(String[] args) {
//        RunUtil.run(new long[]{
//                0b1,
//                0b111,
//                0
//        }, new long[]{
//                0b011,
//                0b010,
//                0b010
//        },2,0,0,2,2
//        );
        Set<Integer> set = new HashSet<>();
        set.iterator();
        RunUtil.run(new String[]{"..A.A.AAA...AAAAAA.AA..A..A.A......A.AAA.AAAAAA.AA"},2);
    }
}
