package CN;

import java.util.Arrays;

public class CN135 {
    class Solution {
        public int candy(int[] ratings) {
            boolean[] left = new boolean[ratings.length];
            boolean[] right = new boolean[ratings.length];
            int[] candies = new int[ratings.length];
            for(int i=0;i<ratings.length;i++){
                if(i==0){
                    left[i] = false;
                }
                else{
                    left[i] = ratings[i-1]<ratings[i];
                }

                if(i==ratings.length-1){
                    right[i] = false;
                }
                else{
                    right[i] = ratings[i+1]<ratings[i];
                }
                candies[i] = 1;
            }
            for(int i=0;i<ratings.length;i++){
                if(left[i]){
                    candies[i] = candies[i-1]+1;
                }
            }
            for(int i=ratings.length-1;i>=0;i--){
                if(right[i]){
                    candies[i] = Math.max(candies[i+1]+1,candies[i]);
                }
            }
            return Arrays.stream(candies).reduce(Integer::sum).getAsInt();
        }
    }
}
