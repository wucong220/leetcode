package com.wu;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2020/5/21 10:17
 */
public class P1449 {


    class Solution {
        public String largestNumber(int[] cost, Integer target){
            Map<Integer,Integer> map = new HashMap<>(cost.length);
            for(int i=0;i<cost.length;i++){
                if(map.containsKey(cost[i])){
                    cost[map.get(cost[i])]=Integer.MAX_VALUE;
                    map.put(cost[i], i);
                }
                else{
                    map.put(cost[i], i);
                }
            }
            BigInteger[] d = new BigInteger[target+1];
            for(int i=1;i<=target;i++) {
                BigInteger max = new BigInteger("0");
                for (int j = 0; j < cost.length; j++) {
                    if (cost[j] < i && i-cost[j]>0) {
                        BigInteger temp = d[i-cost[j]];
                        if (!temp.equals(new BigInteger("0"))) {
                            BigInteger bigTemp = new BigInteger(""+(j + 1) + temp);
                            if (max.compareTo(bigTemp) < 0) {
                                max = bigTemp;
                            }
                        }
                    } else if (cost[j] == i) {
                        BigInteger bigTemp = new BigInteger(String.valueOf(j + 1));
                        if (max.compareTo(bigTemp) < 0) max = bigTemp;
                    }
                }
                d[i]=max;
            }
            return d[target].toString();
        }
    }

    public static void main(String[] args) {
//        RunUtil.run(new int[]{4,3,2,5,6,7,2,5,5},9);
        RunUtil.run(new int[]{1,1,1,1,1,1,1,1,1},5000);
    }
}
