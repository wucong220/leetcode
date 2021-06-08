package com.wu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wuc006
 * @date 2021/4/5 16:04
 */
public class Q3 {
    class Solution {
        public int magicTower(int[] nums) {
            int asInt = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
            if(asInt<0)return -1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int hp = 0;
            int mov = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<0){
                    pq.offer(nums[i]);
                }
                hp+=nums[i];
                if(hp<0){
                    Integer min = pq.poll();
                    hp-=min;
                    mov++;
                }
            }
            return mov;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[100,100,100,-250,-60,-140,-50,-50,100,150]"));
    }
}
