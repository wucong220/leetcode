package com.wu.bd;

import com.wu.RunUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wuc006
 * @date 2021/5/20 10:25
 */
public class 求区间最小数乘区间和的最大值 {
    /**
     * 给定一个数组，要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：区间中的最小数 * 区间所有数的和。
     *
     * 数组中的元素都是非负数。
     *
     * 输入两行，第一行n表示数组长度，第二行为数组序列。输出最大值。
     *
     * 输入
     * 3
     * 6 2 1
     * 输出
     * 36
     * 解释：满足条件区间是[6] = 6 * 6 = 36;
     */

    public static int run(int[] array){
        int preSum[] = new int[array.length];
        for(int i=0;i<array.length;i++){
            preSum[i] = (i==0?0:preSum[i-1]) + array[i];
        }
        Deque<Integer> monoDecQ = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(monoDecQ.isEmpty()){
                monoDecQ.offer(i);
            }
            else{
                while(!monoDecQ.isEmpty()&&array[monoDecQ.peek()]>array[i]){
                    Integer curr = monoDecQ.poll();
                    int left=-1;
                    if(!monoDecQ.isEmpty())left = monoDecQ.peek();
                    max = Math.max(array[curr]*(preSum[i-1]-(left>=0?preSum[left]:0)),max);
                }
            }
        }

        while(!monoDecQ.isEmpty()){
            Integer curr = monoDecQ.poll();
            int left=-1;
            if(!monoDecQ.isEmpty())left = monoDecQ.peek();
            max = Math.max(array[curr]*(preSum[array.length-1]-(left>=0?preSum[left]:0)),max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(run((int[]) RunUtil.toArray("[6,2,1]")));
    }
}
