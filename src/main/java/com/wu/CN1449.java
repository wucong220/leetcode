package com.wu;

public class CN1449 {
    class Solution {
        public String largestNumber(int[] cost, int target) {
            //首先我知道这题一定是动态规划
            //问题就是选择诺干个数可以达到的最大和是多少。
            //每个数被一个成本给约束了
            //我们遍历肯定要按照cost的数组遍历，那么每个cost意味着用与不用、以及用几个的情况下，我们所能达到的最大和
            int[][] totalCtr =new int[cost.length+1][target+1];
            int[][] ctr = new int[cost.length+1][target+1];
            for(int i=1;i<=cost.length;i++){
                for(int j=0;j<=target;j++){
                    totalCtr[i][j] = 0;
                    for(int k=0;k*cost[i-1]<j;k++){
                        if(totalCtr[i-1][j-k*cost[i-1]]!=0
                                &&totalCtr[i-1][j-k*cost[i-1]]+k>=totalCtr[i][j]){
                            ctr[i][j] = k;
                            totalCtr[i][j] = k + totalCtr[i-1][j-k*cost[i-1]];
                        }
                    }
                    if(j%cost[i-1]==0){
                        int k = j/cost[i-1];
                        if(k>=totalCtr[i][j]){
                            ctr[i][j] = k;
                            totalCtr[i][j] = k;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=9;i>=1;i--){
                int c = ctr[i][target];
                target-=c*cost[i-1];
                for(int j=0;j<c;j++){
                    sb.append(i);
                }
            }
            return sb.length()==0?"0":sb.toString();
        }
    }

    public static void main(String[] args) {
        int[] cost = new int[]{13,12,9,12,15,11,10,11,15,52};
        int target = 52;
        RunUtil.run(cost,target);
    }
}
