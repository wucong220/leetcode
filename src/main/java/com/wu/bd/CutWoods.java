package com.wu.bd;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/4/22 15:19
 */
public class CutWoods {

    public void cutWoods(int[] array,int k){
        Arrays.sort(array);
        int[] useful = Arrays.copyOfRange(array, array.length - k, array.length);
        //https://leetcode-cn.com/circle/discuss/LV19z5/
    }

    public static void main(String[] args) {



    }
}
