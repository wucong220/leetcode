package com.wu.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @author wuc006
 * @date 2021/6/9 17:27
 */
public class SortTest {
    static void run(Consumer<int[]> sort){
        Random random =new Random();
        int[] array = new int[random.nextInt(20)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(array));
        sort.accept(array);
        System.out.println(Arrays.toString(array));
    }
}
