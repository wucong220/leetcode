package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/2/28 14:44
 */
public class CN5692 {
    class Solution {
        public double[] getCollisionTimes(int[][] cars) {
            //A->B->C;
            double[] ret = new double[cars.length];
            int[] chased = new int[cars.length];
            for (int i = cars.length - 1; i >= 0; i--) {
                if (i == cars.length - 1) {
                    ret[i] = -1;
                    chased[i] = -1;
                } else if (ret[i + 1] == -1) {
                    if (cars[i][1] <= cars[i + 1][1]) {
                        ret[i] = -1;
                        chased[i] = -1;
                    } else {
                        ret[i] = (double) (cars[i + 1][0] - cars[i][0]) / (cars[i][1] - cars[i + 1][1]);
                        chased[i] = i + 1;
                    }
                } else {
                    ret[i] = Integer.MAX_VALUE;
                    chased[i] = -1;

                    double try_to_chase_next = (double) (cars[i + 1][0] - cars[i][0]) / (cars[i][1] - cars[i + 1][1]);
                    if(try_to_chase_next>0) {
                        ret[i] = try_to_chase_next;
                        chased[i] = i + 1;
                    }

                    int index =i+1;
                    while (chased[index] != -1) {
                        int chased_index = chased[index];
                        double try_to_chase_chased = (double) (cars[chased_index][0] - cars[i][0]) / (cars[i][1] - cars[chased_index][1]);
                        if(try_to_chase_chased>0&&try_to_chase_chased<ret[i]){
                            ret[i] = try_to_chase_chased;
                            chased[i] = chased_index;
                        }
                        index = chased_index;
                    }

                    if (ret[i] == Integer.MAX_VALUE) ret[i] = -1;
                }
            }
//            System.out.println(Arrays.toString(ret));
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[3,4],[5,4],[6,3],[9,1]]"));
    }
}
