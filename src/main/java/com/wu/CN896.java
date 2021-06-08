package com.wu;

/**
 * @author wuc006
 * @date 2021/2/28 13:32
 */
public class CN896 {
    class Solution {
        public boolean isMonotonic(int[] A) {
            int monoFlag = 0;
            for(int i=0;i<A.length-1;i++){
                if(monoFlag==0){
                    if(A[i]<A[i+1]){
                        monoFlag=1;
                    }
                    else if(A[i]>A[i+1]){
                        monoFlag=-1;
                    }
                }
                else if(monoFlag==1){
                    if(A[i]>A[i+1])return false;
                }
                else {
                    if(A[i]<A[i+1])return false;
                }
            }
            return true;
        }
    }
}
