package com.wu;

public class CN978 {
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int odd_gap = 0;
            int even_gap = 0;
            int max = 0;
            for(int i=0;i<arr.length-1;i++){
                if(i%2==1){
                    if(arr[i]<arr[i+1]){
                        odd_gap++;
                        even_gap = 0;
                    }
                    else if(arr[i]>arr[i+1]){
                        even_gap++;
                        odd_gap=0;
                    }
                    else{
                        odd_gap=0;
                        even_gap=0;
                    }
                }
                else{
                    if(arr[i]<arr[i+1]){
                        even_gap++;
                        odd_gap=0;
                    }
                    else if(arr[i]>arr[i+1]){
                        odd_gap++;
                        even_gap=0;
                    }
                    else{
                        odd_gap=0;
                        even_gap=0;
                    }
                }
                max = Math.max(odd_gap,max);
                max = Math.max(even_gap,max);
            }
            return max+1;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[9,4,2,10,7,8,8,1,9]"));
    }
}
