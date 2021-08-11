package com.wu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/7/30 11:42
 */
public class CN1104 {
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            //2^0 + 2^1      到第i行  2^i -1 个元素
            //2^(i-1)-1<label<=2^i-1;
            int level = 0;
            for(int i=1;(1<<i)-1<=(1<<30);i++){
                if(label>(1<<(i-1))-1&&label<=(1<<i)-1){
                    level = i;
                    break;
                }
            }
            LinkedList<Integer> ret = new LinkedList<>();

            while(label>0){
                ret.addFirst(label);
                if(level%2==0){
                    int preCount = (1<<(level-1))-1;
                    int currCount = (1<<level)-1;
                    int trueIndex = currCount+1-label + preCount;
                    label = trueIndex/2;
                    level--;
                }else{
                    label = label/2;
                    level--;
                    int preCount = (1<<(level-1))-1;
                    int currCount = (1<<level)-1;
                    label = currCount+1-label + preCount;
                }

            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(14);
    }
}
